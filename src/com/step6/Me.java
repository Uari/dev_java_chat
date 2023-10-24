package com.step6;

public class Me extends Super1 {

	public void methodC() {
		System.out.println("methodC() 호출");
	}
	public static void main(String[] args) {
		Me me = new Me();
		Super1 sup1 = new Me();  //다형성
		Super1 sup11 = new Super1();  //다형성
		
		System.out.println(me.a);
		me.methodA();
		me.methodC();
		sup1.methodA();
		sup1.methodC();
	}
}
