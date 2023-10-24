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

public class TalkClientOne extends JFrame implements ActionListener {
	
	Socket socket = null;
	ObjectOutputStream oos = null;// 말 하고 싶을 때
	ObjectInputStream ois = null;// 듣기 할 때

	JPanel jp_second = new JPanel();
	JPanel jp_second_south = new JPanel();
	//JButton jbtn_one = new JButton("1:1");
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
	
	String nickName2;
	String selectedNickname;

	public TalkClientOne(String nickName2, String selectedNickname) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.nickName2 = nickName2;
		this.selectedNickname = selectedNickname;
		initDisplay();
		init();
	}

	public void initDisplay() {
		//jbtn_one.addActionListener(this);
		jtf_msg.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_font.addActionListener(this);
		
		// 사용자의 닉네임 받기
		//nickName = loginForm.nickName;  //test일때 실행시키지 않음
		
		this.setLayout(new GridLayout(1, 2));
		jp_second.setLayout(new BorderLayout());
		jp_second.add("Center", jsp);
		jp_second_south.setLayout(new GridLayout(2, 2));
		//jp_second_south.add(jbtn_one);
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
		this.setTitle(nickName2+"님 "+selectedNickname+"님의 1:1 대화방");
		this.setSize(800, 550);
		this.setVisible(true);
	}
	
	public void init() {
		//통신하는 로직
		/*try {
			//socket = new Socket("172.16.2.27", 3002);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(300+"|"+nickName2+"|"+selectedNickname);
			
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
	}
}
