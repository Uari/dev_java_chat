package com_step1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//자바에서는 디폴트 패키지외에는 모두 패키지명을 다 적어야 하는데
//반복되는 코드가 발생하므로 import예약어를 지원함
import javax.swing.JFrame;

public class JFrameTest6 implements ActionListener{ //클래스 선언
	static JFrameTest6 jft5 = new JFrameTest6();
	//JFrame jf = new JFrame();
	JFrame jf = new JFrame();
	JButton jbtnAccount = new JButton("연산하기");
	JButton jbtnExit = new JButton("나가기");
	//인스턴스변수.변수명으로 호출이 가능함 -> 전변
		
	public static void main(String[] args) {
		
		//JFrameTest6 jft5 = new JFrameTest6();
		jft5.jf.setTitle("6번");
		jft5.jbtnAccount.addActionListener(jft5);
		jft5.jf.add("North", jft5.jbtnExit);
		jft5.jf.add("South", jft5.jbtnAccount);
		jft5.jf.setSize(500, 400);
		jft5.jf.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌려진 버튼의 주소번지를 JVM으로 부터 알아낸다
		Object obj = e.getSource(); //눌려진 버튼의 주소번지 가져옴
		if(obj == jft5.jbtnAccount) {
			System.out.println("버튼눌림");
		}
	}
}
