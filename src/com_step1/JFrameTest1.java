package com_step1;

//자바에서는 디폴트 패키지외에는 모두 패키지명을 다 적어야 하는데
//반복되는 코드가 발생하므로 import예약어를 지원함
import javax.swing.JFrame;

public class JFrameTest1 {
	
	//선언부
	//자바가 제공하는 클래스를 호출하려면 인스턴스화 해야한다.
	//아래 문자를 작성하면 jf 라는 변수로 그 클래스가 소유(정의된)하고 있는 전역변수나 메소드를 호출할 수 있다.
	JFrame jf = new JFrame(); 
	//클래스 이름에 빨간줄은 JVM이 해당 클래스 이름을 찾을 수 없을때 표시
		
	//생성자 선언
		
	//사용자 정의 메소드 선언 - 화면애 윈도우창을 하나 띄워본다
	public void initDisplay() {
		//setTitle메소드의 파라미터 자리에는 문자열 타입이 와야 함
		//이미 타입이 결정되어 있다
		jf.setTitle("에베베벱베");
		jf.setSize(500, 400);
		jf.setVisible(true);
		jf.setVisible(false);
		jf.setVisible(true);
	}
		
	//Main메소드 선언 - 가장먼저 실행 - JVM이 호출
	public static void main(String[] args) {
			//구현된 메소드라 하더라도 메인메소드 안에서 호출하려면 인스턴스화
		JFrameTest1 jft = new JFrameTest1(); //인스턴스화
		jft.initDisplay(); //호출
	}
}
/*
 * 클래스 선언이 먼저 - 인스턴스화
 * 인스턴스화 라는 건 메모리(Ram)에 개발자가 작성한 문서를 로딩하는 것
 * 
 */
