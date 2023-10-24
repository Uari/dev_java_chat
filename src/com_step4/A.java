package com_step4;

public class A {
	int i = 1;
	
	void methodA() {
		System.out.println(this.i); //2?
	}

	public static void main(String[] args) {
		A a =new A();
		a.i = 2;
		A b =new A();
		a.i = 3;
		a.methodA();
	}
}
