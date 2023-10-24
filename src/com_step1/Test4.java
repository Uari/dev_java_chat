package com_step1;

public class Test4 {

	//메인메소드는 콜백이라서 개발자가 호출할 수 없다.
	public static void main(String[] args) {
		Test2 t2 = new Test2();
		t2.methodC();
		
		t2 = new Test2();
		t2.methodC();
		System.out.println(P.i);
		//주소를 참조해서 바꾼 변수는 원래 값도 변한다.
	}
}
