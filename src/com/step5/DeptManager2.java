package com.step5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class DeptManager2 extends JFrame implements ActionListener {
	// 선언부
	List<Map<String, Object>> deptList = new ArrayList<>();
	String header[] = { "부서번호", "부서명", "지역" };
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
	public DeptManager2() {
		getDeptList();
		initDisplay();
	}

	public List<Map<String, Object>> getDeptList() {
		Map<String, Object> map = new HashMap<>();
		map.put("DEPTNO", 10);
		map.put("DNAME", "영업부");
		map.put("LOC", "부산");
		deptList.add(map);
		
		map = new HashMap<>();
		map.put("DEPTNO", 20);
		map.put("DNAME", "개발부");
		map.put("LOC", "대구");
		deptList.add(map);

		map = new HashMap<>();
		map.put("DEPTNO", 30);
		map.put("DNAME", "인사부");
		map.put("LOC", "서울");
		deptList.add(map);

		return deptList;
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

	// 메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		DeptManager2 dm = new DeptManager2();
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
				System.out.println(map + "rdept.get(DEPTNO):" + map.get("DEPTNO"));
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
		while (dtm_dept.getRowCount() > 0) {
			dtm_dept.removeRow(0);
		}
		for (int i = 0; i < deptList.size(); i++) {
			Map<String, Object> map = deptList.get(i);
			Vector<Object> v = new Vector<>();
			v.add(0, map.get("DEPTNO"));
			v.add(1, map.get("DNAME"));
			v.add(2, map.get("LOC"));
			dtm_dept.addRow(v);
		}
	}///////////////// end of refreshData//////////////////
}
