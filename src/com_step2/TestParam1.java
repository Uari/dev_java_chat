package com_step2;

class Param1{
	//전역변수는 초기화 생략 가능 - ? -> 생성자가 대신 해줌
	int ival; //전역변수 - default = 0
}

public class TestParam1 {

	void effectParam(Param1 p) { //p = null;
		p.ival = 100; 	//사용 x - NullPointerException
		System.out.println("sub ival ==> " + p.ival);
	}
	
	public static void main(String[] args) {
		Param1 p = new Param1();
		p.ival = 500;
		TestParam1 tp = new TestParam1();
		tp.effectParam(p);
		System.out.println("main ival ==> " + p.ival);
	}
}
