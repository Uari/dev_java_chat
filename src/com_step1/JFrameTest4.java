package com_step1;

//자바에서는 디폴트 패키지외에는 모두 패키지명을 다 적어야 하는데
//반복되는 코드가 발생하므로 import예약어를 지원함
import javax.swing.JFrame;

public class JFrameTest4 { //클래스 선언
	
	//JFrame jf = new JFrame();
	//static JFrame jf = new JFrame(); //1_1
		
	public static void main(String[] args) {
		JFrameTest3 jft = new JFrameTest3();//jft는 지역변수
		
		JFrame jf = new JFrame(); //1_2
		
		jft.jf.setTitle("3번");
		jft.jf.setSize(500, 400);
		jft.jf.setVisible(true);
		
		jf.setTitle("4번");
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
}
