package com_step1;

class P{
	static int i = 1;
	int j = 10;
}

public class Test2 {
	
	public void methodC(){
		P.i = P.i+2;
	}

	public static void main(String[] args) {

		//static이 붙은 변수 i는 호출 할때 클래스명을 사용한다.
		P.i = 2;
		System.out.println(P.i);
		
	}
}
