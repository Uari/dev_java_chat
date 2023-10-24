package com_step1;

//자바에서는 디폴트 패키지외에는 모두 패키지명을 다 적어야 하는데
//반복되는 코드가 발생하므로 import예약어를 지원함
import javax.swing.JFrame;

public class JFrameTest2 { //클래스 선언
	
	JFrame jf = new JFrame(); 
		
	//Main메소드 선언 - 가장먼저 실행 - JVM이 호출
	public static void main(String[] args) {
			//구현된 메소드라 하더라도 메인메소드 안에서 호출하려면 인스턴스화
		JFrameTest1 jft = new JFrameTest1(); //인스턴스화한것이 JFrameTest2가 아니라 JFrameTest1 이라서 JFrameTest1를 참조한다.
		jft.initDisplay(); //호출
		
		//JFrameTest2 jft2 = new JFrameTest2();
		//jft2.iniDisplay();  // JFrameTest2 클래스 내에 iniDisplay 메서드가 존재 하지 않음 
	}
}
/*
 	
  
 */
