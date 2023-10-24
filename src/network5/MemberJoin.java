package network5;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MemberJoin extends JDialog implements ActionListener{
    //선언부
    JPanel jp_center = new JPanel();
    JLabel jlb_id = new JLabel("아이디");
    JTextField jtf_id = new JTextField(10);
    JButton jbtn_idcheck = new JButton("중복체크");
    JLabel jlb_pw = new JLabel("패스워드");
    JTextField jtf_pw = new JTextField(10);
    JLabel jlb_nickName = new JLabel("대화명");
    JTextField jtf_nickName = new JTextField(20);
    JLabel jlb_name = new JLabel("성명");
    JTextField jtf_name = new JTextField(30);
    JLabel jlb_gender = new JLabel("성별");
    String[] genderList = {"남자","여자"};
    JComboBox jcb_gender = new JComboBox(genderList);
    JLabel 		jlb_zipcode = new JLabel("우편번호");
    public JTextField 	jtf_zipcode = new JTextField(6);
    JLabel 		jlb_address = new JLabel("주소");
    public JTextField 	jtf_address = new JTextField(100);
    JButton     jbtn_zipcode = new JButton("우편번호찾기");
    JScrollPane jsp = null;
    JPanel jp_south = new JPanel();
    JButton jbtn_ins = new JButton("등록");
    JButton jbtn_close = new JButton("닫기");
    //우편번호 검색기 클래스를 전역변수 자리에서 생성한다.
    ZipCodeView zcv = null;
    ChatDao cd = new ChatDao(this);
    
    boolean idCheck = false;
    
    //생성자
    public MemberJoin(){
    	initDisplay();
    }
    
    //화면처리부
    public void initDisplay() {
    	jbtn_idcheck.addActionListener(this);
    	jbtn_ins.addActionListener(this);
        jbtn_zipcode.addActionListener(this);
        jbtn_close.addActionListener(this);
        jp_center.setLayout(null);
        
        jlb_id.setBounds(20, 20, 100, 20);
        jtf_id.setBounds(120, 20, 120, 20);
        jbtn_idcheck.setBounds(240, 20, 100, 20);
        jlb_pw.setBounds(20, 45, 100, 20);
        jtf_pw.setBounds(120, 45, 120, 20);
        jlb_nickName.setBounds(20, 70, 100, 20);
        jtf_nickName.setBounds(120, 70, 150, 20);
        jlb_name.setBounds(20, 95, 100, 20);
        jtf_name.setBounds(120, 95, 150, 20);
        jlb_gender.setBounds(20, 120, 100, 20);
        jcb_gender.setBounds(120, 120, 150, 20);
        jcb_gender.setFont(new Font("굴림",1,14));
        jlb_zipcode.setBounds(20, 145, 100, 20);
        jtf_zipcode.setBounds(120, 145, 100, 20);
        jbtn_zipcode.setBounds(230, 145, 120, 20);
        jlb_address.setBounds(20, 170, 100, 20);
        jtf_address.setBounds(120, 170, 250, 20);
        
        jp_center.add(jlb_id);
        jp_center.add(jtf_id);
        jp_center.add(jbtn_idcheck);
        jp_center.add(jlb_pw);
        jp_center.add(jtf_pw);
        jp_center.add(jlb_nickName);
        jp_center.add(jtf_nickName);
        jp_center.add(jlb_name);
        jp_center.add(jtf_name);
        jp_center.add(jlb_gender);
        jp_center.add(jcb_gender);
        jp_center.add(jlb_zipcode);
        jp_center.add(jtf_zipcode);
        jp_center.add(jbtn_zipcode);
        jp_center.add(jlb_address);
        jp_center.add(jtf_address);
        
        jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jp_south.add(jbtn_ins);
        jp_south.add(jbtn_close);
        jtf_zipcode.setEditable(false);
        this.add("South",jp_south);
        jsp = new JScrollPane(jp_center);
        this.add("Center",jsp);
        this.setTitle("회원가입");
        this.setSize(400, 500);
        this.setVisible(true);
    }
    
    /*public static void main(String[] args) {
    	MemberJoin mj = new MemberJoin();
        mj.initDisplay();
    }*/
    
    //비밀번호는 최소 8~20자리에 숫자, 문자, 특수문자 각 1개 이상 사용 (정규표현식)
    public boolean isNumeric(String str) {
    	return Pattern.matches("^^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", str);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("action");
        Object obj = e.getSource();
        
        if(idCheck && (obj == jbtn_zipcode)) {
            //insert here 우편번호 검색기
        	new ZipCodeView(this);

        }else if(obj == jbtn_close) {
        	dispose();
        }else if(idCheck && (obj == jbtn_ins)) {
        	if(!(isNumeric(jtf_pw.getText()))) {
        		JOptionPane.showMessageDialog(this, "비밀번호는 최소 8~20자리에 숫자, 문자, 특수문자 각 1개 이상 사용해야 합니다.", "경고", 2);
        		jtf_pw.setText("");
        	}else {
        		if(("".equals(jtf_nickName.getText()))&&("".equals(jtf_name.getText()))) {
        			JOptionPane.showMessageDialog(this, "빈칸을 채워주세요.", "경고", 2);
        		}else {
        			cd.join();
        		}
        	}
        }else if(obj == jbtn_idcheck) {
        	if("".equals(jtf_id.getText())) {
        		JOptionPane.showMessageDialog(this, "사용하실 아이디를 입력하세요.", "경고", 2);
        	}else {
        		idCheck = cd.idcheck(jtf_id);
        	}
        }else if(!idCheck) {
        	JOptionPane.showMessageDialog(this, "아이디 중복체크 먼저 ..", "경고", 2);
        }
    }
}