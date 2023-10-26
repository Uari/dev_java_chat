package network5;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com_step4.View;

public class TalkClient extends JFrame implements ActionListener {

	Socket socket = null;
	ObjectOutputStream oos = null;// 말 하고 싶을 때
	ObjectInputStream ois = null;// 듣기 할 때
	String nickName = null;// 닉네임 등록

	JPanel jp_second = new JPanel();
	JPanel jp_second_south = new JPanel();
	JButton jbtn_one = new JButton("1:1");
	JButton jbtn_change = new JButton("대화명변경");
	JButton jbtn_font = new JButton("글자색");
	JButton jbtn_exit = new JButton("나가기");
	String cols[] = { "대화명" };
	String data[][] = new String[0][1];
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	JPanel jp_first = new JPanel();
	JPanel jp_first_south = new JPanel();
	JTextField jtf_msg = new JTextField(20);// south속지 center
	JButton jbtn_send = new JButton("전송");// south속지 east
	JTextArea jta_display = null;
	JScrollPane jsp_display = null;

	LoginForm loginForm = null;

	JFrame jf = null;
	JPanel mjp_second = null;
	JPanel mjp_second_south = null;
	// JButton mjbtn_one = new JButton("1:1");
	JButton mjbtn_exit = null;
	String mcols[] = { "대화명" };
	String mdata[][] = new String[0][1];
	DefaultTableModel mdtm = null;
	JTable mjtb = null;
	JScrollPane mjsp = null;
	JPanel mjp_first = null;
	JPanel mjp_first_south = null;
	JTextField mjtf_msg = null;// south속지 center
	JButton mjbtn_send= null;// south속지 east
	JTextArea mjta_display = null;
	JScrollPane mjsp_display = null;

	public TalkClient() {

	}

	public TalkClient(LoginForm loginForm) {
		this.loginForm = loginForm;
		JFrame.setDefaultLookAndFeelDecorated(true);
		nickName = loginForm.nickName;
		initDisplay();
		init();
	}

	public void initDisplay() {
		jbtn_one.addActionListener(this);
		jtf_msg.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_font.addActionListener(this);

		// 사용자의 닉네임 받기
		// nickName = loginForm.nickName; //test일때 실행시키지 않음

		this.setLayout(new GridLayout(1, 2));
		jp_second.setLayout(new BorderLayout());
		jp_second.add("Center", jsp);
		jp_second_south.setLayout(new GridLayout(2, 2));
		jp_second_south.add(jbtn_one);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_font);
		jp_second_south.add(jbtn_exit);
		jp_second.add("South", jp_second_south);
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center", jtf_msg);
		jp_first_south.add("East", jbtn_send);
		jta_display = new JTextArea();
		jta_display.setLineWrap(true);
		jta_display.setOpaque(false);
		Font font = new Font("굴림체", Font.BOLD, 16);
		jta_display.setFont(font);
		jsp_display = new JScrollPane(jta_display);
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_first_south);
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName);
		this.setSize(800, 550);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initDisplay2() {
		jf = new JFrame();
		mjp_second = new JPanel();
		mjp_second_south = new JPanel();
		// JButton mjbtn_one = new JButton("1:1");
		mjbtn_exit = new JButton("나가기");
		mdtm = new DefaultTableModel(mdata, mcols);
		mjtb = new JTable(mdtm);
		mjsp = new JScrollPane(mjtb);
		mjp_first = new JPanel();
		mjp_first_south = new JPanel();
		mjtf_msg = new JTextField(20);// south속지 center
		mjbtn_send = new JButton("전송");// south속지 east
		mjta_display = new JTextArea();
		mjsp_display = new JScrollPane(mjta_display);
		
		mjtf_msg.addActionListener(this);
		mjbtn_exit.addActionListener(this);
		
		jf.setLayout(new GridLayout(1, 2));
		mjp_second.setLayout(new BorderLayout());
		mjp_second.add("Center", mjsp);
		mjp_second_south.setLayout(new GridLayout(2, 2));
		// mjp_second_south.add(jbtn_one);
		mjp_second_south.add(mjbtn_exit);
		mjp_second.add("South", mjp_second_south);
		mjp_first.setLayout(new BorderLayout());
		mjp_first_south.setLayout(new BorderLayout());
		mjp_first_south.add("Center", mjtf_msg);
		mjp_first_south.add("East", mjbtn_send);
		mjta_display = new JTextArea();
		mjta_display.setLineWrap(true);
		mjta_display.setOpaque(false);
		Font mfont = new Font("굴림체", Font.BOLD, 16);
		mjta_display.setFont(mfont);
		mjsp_display = new JScrollPane(mjta_display);
		mjp_first.add("Center", mjsp_display);
		mjp_first.add("South", mjp_first_south);
		
		jf.add(mjp_first);
		jf.add(mjp_second);
		jf.setTitle("1:1 대화방");
		jf.setSize(500, 550);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init() {
		// 통신하는 로직
		try {
			socket = new Socket("172.16.2.27", 3002);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			oos.writeObject(100 + "|" + nickName);

			TalkClientThread tct = new TalkClientThread(this);
			tct.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		TalkClient tc = new TalkClient();
		tc.nickName = "test1";
		tc.initDisplay();
		tc.init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 100(접속)|200(1:1대화)|201(대화)|202(대화명 바꾸기)|500(나가기)
		if (obj == jbtn_exit) {// protocol : 500
			String exitMsg = nickName + "님이 대화방을 나가셨습니다.\n";
			try {
				oos.writeObject(500 + "|" + nickName + "|" + exitMsg);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.dispose();
			loginForm.setVisible(true);

		} else if (obj == jtf_msg) {// 대화 protocol : 201
			String msg = jtf_msg.getText();
			try {
				oos.writeObject(201 + "|" + nickName + "|" + msg);
				jtf_msg.setText("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (obj == jbtn_change) {// protocol : 202
			String afterNickName = JOptionPane.showInputDialog("변경할 대화명을 입력하세요.");
			String changeMsg = nickName + "의 대화명이 " + afterNickName + "으로 변경되었습니다. \n";
			if (afterNickName == null || afterNickName.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "변경할 대화명을 입력하세요", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			try {
				oos.writeObject(202 + "|" + nickName + "|" + afterNickName + "|" + changeMsg);
			} catch (Exception e2) {

			}
		} else if (obj == jbtn_font) {// protocol : 203
			String[] fontColor = { "Red", "Blue", "Green", "Black" };
			Object selected = JOptionPane.showInputDialog(null, "원하는 색을 선택 하세요!!", "글자색 변경",
					JOptionPane.QUESTION_MESSAGE, null, fontColor, fontColor[3]);
			if (selected == null) {
				JOptionPane.showMessageDialog(null, "뭐야.. 원하는거 없어??;");
			} else {
				try {
					oos.writeObject(203 + "|" + nickName + "|" + selected);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		} else if (obj == jbtn_one) {// protocol : 200
			int rowNum = 0;
			int selectedRowNum = jtb.getSelectedRow();
			String selectedNickname = (String) jtb.getValueAt(selectedRowNum, 0);
			
			for(int i = 0; i<dtm.getRowCount(); i++) {
				if(nickName.equals((String)dtm.getValueAt(i, 0))) {
					rowNum = i;
					break;
				}
			}
			
			if (nickName.equals(selectedNickname)) {
				JOptionPane.showMessageDialog(null, "잘못 선택 하셨습니다.");
			} else {
				try {
					oos.writeObject(200 + "|" + nickName + "|" + selectedNickname+"|"+rowNum+"|"+selectedRowNum);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (obj == mjtf_msg) {
			String msg = mjtf_msg.getText();
			try {
				oos.writeObject(301 + "|" + nickName + "|" + msg);
				mjtf_msg.setText("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(obj == mjbtn_exit) {
			String exitMsg = nickName + "님이 대화방을 나가셨습니다.\n";
			try {
				oos.writeObject(600 + "|" + nickName + "|" + exitMsg);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jf.dispose();
		}
	}
}
