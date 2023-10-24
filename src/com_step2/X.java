package com_step2;

public class X {

	void methodA() {
		System.out.println("methodA() 호출");
	}
	void methodA(int i) {
		System.out.println("methodA(int i) 호출");
	}
	void methodA(int i, int j) {
		System.out.println("methodA(int i, int j) 호출");
	}
	public static void main(String[] args) {
		X x = new X();
		
		x.methodA();
		x.methodA(0);
		x.methodA(0, 0);
		
		
		
		
		
	}
}
