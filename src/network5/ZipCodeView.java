package network5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.jdbc.DBConnectionMgr;

public class ZipCodeView extends JFrame implements ActionListener, MouseListener {
	// 선언부
	String zdo = null;
	// 물리적으로 떨어져 있는 db서버와 연결통로 만들기
	Connection con = null;
	// 위에서 연결되면 쿼리문을 전달할 전령의 역할을 하는 인터페이스 객체 생성하기
	PreparedStatement pstmt = null;
	// 조회된 결과를 화면에 처리해야 하므로 오라클에 커서를 조작하기 위해 ResultSet추가
	ResultSet rs = null;
	DBConnectionMgr dbMgr = null;

	JPanel jp_north = new JPanel();
	// insert here
	String zdos[] = { "전체", "서울", "경기", "강원" };
	String zdos2[] = { "전체", "부산", "전남", "대구" };
	Vector<String> vzdos = new Vector<>();// vzdos.size()==>0
	JComboBox jcb_zdo = new JComboBox(zdos);// West
	JComboBox jcb_zdo2 = null;// West
	JTextField jtf_search = new JTextField("동이름을 입력하세요.");// Center
	JButton jbtn_search = new JButton("조회");// East
	String cols[] = { "우편번호", "주소" };
	String data[][] = new String[0][2];
	DefaultTableModel dtm_zipcode = new DefaultTableModel(data, cols);
	JTable jtb_zipcode = new JTable(dtm_zipcode);
	JTableHeader jth = jtb_zipcode.getTableHeader();
	JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	String zdos3[] = null;
	MemberJoin mj = null;

	// MemberShip memberShip = null;
	// 생성자
	public ZipCodeView() {
		
	}

	public ZipCodeView(MemberJoin mj) {
		this.mj = mj;
		dbMgr = DBConnectionMgr.getInstance();
		initDisplay();
	}

	// 화면처리부
	public void initDisplay() {
		jtb_zipcode.requestFocus();
		jbtn_search.addActionListener(this);
		jtf_search.addActionListener(this);
		jtf_search.addMouseListener(this);
		jtb_zipcode.addMouseListener(this);
		jp_north.setLayout(new BorderLayout());
		/*	*/
		// vzdos.copyInto(zdos2);
		for (int x = 0; x < zdos2.length; x++) {
			vzdos.add(zdos2[x]);
		}
		for (String s : vzdos) {
			System.out.println("s===>" + s);
		}
		// jcb_zdo2 = new JComboBox(zdos3);//West
		// jp_north.add("West",jcb_zdo2);
		jp_north.add("Center", jtf_search);
		jp_north.add("East", jbtn_search);
		
		this.add("North", jp_north);
		this.add("Center", jsp_zipcode);
		this.setTitle("우편번호 검색");
		this.setSize(430, 400);
		this.setVisible(true);
	}

	// 메인메소드
	/*public static void main(String[] args) {
		ZipCodeView zcs = new ZipCodeView();
		zcs.dbMgr = DBConnectionMgr.getInstance();
		zcs.initDisplay();
		//zcs.initDisplay();
	}*/

	/*********************************************************
	 * 사용자로부터 동이름을 입력 받아서 조건 검색을 구현하기
	 * 
	 * select zipcode, address
  		from  zipcode_t
  		where dong LIKE ? ||'%';
	 * 
	 * 화면이 존재하는 경우 DB서버에서 가져온 정보를 가지고 후처리를 해야함 
	 * retrun 타입을 void로 했으니까 이 메소드에서 화면처리까지 진행 
	 * UI - react - 화면과 로직 분리(Model계층 - UI + 데이터 셋 만난다)
	 * 데이터셋에 데이터를 추가하는 것은 row단위(1차배열, Vector)로 처리된다. 
	 * DefaultTableModel -> addRow(Object[]), addRow(Vector)
	 * ClassNotFoundException -> ojdbc6.jar -> build path
	 * NullPointException 발동 -> con이 널이다 - ip주소 port 확인
	 * 
	 *********************************************************/
	public void refreshData(String dong) {
		List<Map<String, Object>> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT zipcode, address");
		sql.append(" FROM zipcode_t  ");
		sql.append("WHERE dong LIKE ?||'%'");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			Map<String, Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("zipcode", rs.getInt("zipcode"));
				rmap.put("address", rs.getString("address"));
				list.add(rmap);
			}
			System.out.println(list);
			
			//메소드 설계가 리턴 타입이 바져 있으므로 화면처리까지 해야함
			
			while (dtm_zipcode.getRowCount() > 0) {
				dtm_zipcode.removeRow(0);
			}
			
			for(int i = 0; i<list.size(); i++) {
				Map<String, Object> map = list.get(i);
				Vector<Object> v = new Vector<>();
				v.add(0, map.get("zipcode"));
				v.add(1, map.get("address"));
				dtm_zipcode.addRow(v);
			}
			
		} catch (SQLException se) {
			System.out.println(sql.toString());
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_search || obj == jtf_search) {
			String dong = jtf_search.getText();
			refreshData(dong);
			jtf_search.setText("");
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == jtf_search) {
			jtf_search.setText("");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount()==2) { //더블클릭
			int index = jtb_zipcode.getSelectedRow();
			int zipcode = (int)dtm_zipcode.getValueAt(index, 0); //선택된 로우의 우편번호가 담김
			String address = (String)dtm_zipcode.getValueAt(index, 1);
			System.out.println(zipcode + "," + address);
			
			//부모창인 회원가입 창에서 우편번호와 주소자리에 조회된 결과를 자동으로 출력해줌(부모의 주소번지가 필요함)
			
			mj.jtf_zipcode.setText(String.valueOf(zipcode));
			mj.jtf_address.setText(address);
			dispose();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}