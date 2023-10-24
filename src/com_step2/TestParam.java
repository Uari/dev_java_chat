package com_step2;

class Param{
	//전역변수는 초기화 생략 가능 - ? -> 생성자가 대신 해줌
	int ival; //전역변수 - default = 0
}

public class TestParam {

	void effectParam(Param p) {
		p.ival = 100;
		System.out.println("sub ival ==> " + p.ival);
	}
	
	public static void main(String[] args) {
		Param p = new Param();
		p.ival = 500;
		TestParam tp = new TestParam();
		tp.effectParam(p);
		System.out.println("main ival ==> " + p.ival);
	}
}
