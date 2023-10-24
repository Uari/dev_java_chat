package com_step1;

//자바에서는 디폴트 패키지외에는 모두 패키지명을 다 적어야 하는데
//반복되는 코드가 발생하므로 import예약어를 지원함
import javax.swing.JFrame;

public class JFrameTest5 { //클래스 선언
	
	//JFrame jf = new JFrame();
	JFrame jf = new JFrame(); 
	//인스턴스변수.변수명으로 호출이 가능함 -> 전변
		
	public static void main(String[] args) {
		
		JFrameTest5 jft5 = new JFrameTest5();
		jft5.jf.setTitle("5번");
		jft5.jf.setSize(500, 400);
		jft5.jf.setVisible(true);
	}
}
