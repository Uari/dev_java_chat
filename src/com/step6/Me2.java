package com.step6;

public class Me2 extends Super2 {
	@Override
	public void methodC() {
		System.out.println("Me2:MethodC() 호출");
	}
	public static void main(String[] args) {
		Me2 me = new Me2();
		Super2 sup1 = new Me2();  //다형성
		Super2 sup11 = new Super2();  //다형성
		
		System.out.println(me.a);
		me.methodA();
		me.methodB();
		me.methodC();
		sup1.methodA();
		sup1.methodB();
		sup1.methodC();
		sup11.methodC();
		
		
	}
}
