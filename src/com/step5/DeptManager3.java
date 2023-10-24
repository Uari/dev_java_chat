package com.step5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

public class DeptManager3 extends JFrame implements ActionListener {
	// 선언부
	//JDBC API를 활용하여 오라클 서버에서 부서목록 조회
	Connection con = null;			//연결통로 확보
	PreparedStatement pstmt = null; //Connection 생성되어 PreparedStatement메모리 로딩됨
	ResultSet rs = null;			//open..cursor..fatch..close 커서를 조작해서 원하는 정보를 반환받음
	//공통코드에서 재사용 가능한 메소드를 설계함
	DBConnectionMgr dbMgr = null;
	
	List<Map<String, Object>> deptList = new ArrayList<>();
	String header[] = { "사원번호", "사원명", "연봉", "부서명"};
	String datas[][] = new String[0][0];
	DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);
	
	JTable jt_dept = new JTable(dtm_dept);
	JScrollPane jsp_dept = new JScrollPane(jt_dept);
	JPanel jp_north = new JPanel();
	JButton jbtnSelect = new JButton("조회");
	JButton jbtnDelete = new JButton("삭제");
	JButton jbtnAdd = new JButton("행추가");
	JButton jbtnDel = new JButton("행삭제");
	JButton jbtnExit = new JButton("종료");
	
	

	// 생성자
	public DeptManager3() { 
		//메소드를 통해서 객체를 주입받고 있는데, 연산자 앞에 인스턴스변수가 아니라 클래스 타입이 직접 사용되었다.
		dbMgr = DBConnectionMgr.getInstance();	//싱글톤 패턴
		initDisplay();
	}

	
	// 화면처리부
	public void initDisplay() {
		jbtnSelect.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnAdd.addActionListener(this);
		jbtnDel.addActionListener(this);
		jbtnExit.addActionListener(this);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtnSelect);
		jp_north.add(jbtnDelete);
		jp_north.add(jbtnAdd);
		jp_north.add(jbtnDel);
		jp_north.add(jbtnExit);
		this.add("North", jp_north);
		this.add("Center", jsp_dept);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	
	//select가 모든 업무 페이지의 시작 페이지이므로 맡은 업무의 첫 시작임
	public List<DeptVO> getVOList(){
		System.out.println("제네릭 타입을 getter/setter로 처리할때");
		
		List<DeptVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT deptno, dname, loc FROM dept");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			DeptVO dvo = null;
			
			while(rs.next()) {
				dvo = new DeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getNString("loc"));
				list.add(dvo);
			}
			System.out.println(list);
			
			//자바를 통해서 DB연동한 후 후처리하기 (자바컬렉션 프레임워크를 JSON포맷으로 변경함)
		} catch (SQLException se) {
			System.out.println(se.toString()); //부적합한 식별자 - 컬럼명이 존재하지 않을때 
		} catch(Exception e) {
			e.printStackTrace(); //stack메모리에 쌓여있는 에러 메세지 히스토리를 볼 수 있다.(라인번호와 함께 메세지 출력)
		}
		return list;
	}
	
	public List<Map<String, Object>> getMapList(){ //2개이상의 테이블 조인시 - 이것으로 연습을 더 많이 
		System.out.println("제네릭 타입을 Map으로 처리할 때");
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); //String과 비교할 때 하나로 관리를 함 - 메모리에 대한 이익이 있다.
		//StringBuffer는 스레드 안전, String Builder 불안전하다 - 인터셉트를 당할 수 있다.
		
		//sql.append("SELECT deptno, dname, loc FROM dept");
		
		sql.append("SELECT empno, ename, sal, dname"); 
		sql.append(" FROM emp, dept "); 
		sql.append("WHERE emp.deptno = dept.deptno"); 
		
		try {
			Map<String, Object> map = null;
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				map = new HashMap<>();
				map.put("empno", rs.getInt("empno"));
				map.put("ename", rs.getString("ename"));
				map.put("sal", rs.getInt("sal"));
				map.put("dname", rs.getString("dname"));
				list.add(map);
			}
			
		} catch (SQLException se) {
			System.out.println(se.toString()); 
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return list;
	}
	
	// 메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new DeptManager3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == jbtnSelect) {
			System.out.println("조회버튼 클릭");
			refreshData();

		} else if (obj == jbtnDelete) {
			System.out.println("삭제버튼 클릭");
			int index = jt_dept.getSelectedRow();
			if (index < 0) {
				JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택 하시오.", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			} else {
				Map<String, Object> map = deptList.remove(index);
				//System.out.println(map + "rdept.get(DEPTNO):" + map.get("DEPTNO"));
				if(map != null) {
					JOptionPane.showMessageDialog(this, "삭제 성공하였습니다.", "INFO", JOptionPane.INFORMATION_MESSAGE);
					refreshData();
				}else {
					JOptionPane.showMessageDialog(this, "삭제 실패하였습니다.", "INFO", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}

		} else if (obj == jbtnAdd) {
			System.out.println("추가버튼 클릭");
			//Vector addRow = new Vector();
			Object addRow2[] = new Object[3];
			dtm_dept.addRow(addRow2);
			//refreshData();
			
		} else if (obj == jbtnDel) {
			System.out.println("행삭제버튼 클릭");
			int index = jt_dept.getSelectedRow();
			if (index < 0) {
				JOptionPane.showMessageDialog(this, "삭제할 행을 선택하시오.", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			} else {
				dtm_dept.removeRow(index);
			}
			
		} else if (obj == jbtnExit) {
			System.exit(0);
		}
	}

	public void refreshData() {
		List<Map<String, Object>> list = getMapList(); //오라클 서버에서 조회한 결과를 쥐고 있다.- 리턴타입이 쥐고 있다.
		while (dtm_dept.getRowCount() > 0) {
			dtm_dept.removeRow(0);
		}
		
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			Vector<Object> v = new Vector<>();
			v.add(0, map.get("empno"));
			v.add(1, map.get("ename"));
			v.add(2, map.get("sal"));
			v.add(3, map.get("dname"));
			
			dtm_dept.addRow(v);
		}
	}///////////////// end of refreshData//////////////////
}
