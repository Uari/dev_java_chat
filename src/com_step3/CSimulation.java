package com_step3;

class C{
	int i = 1;
}
public class CSimulation {
	void methodA(C c) {
		System.out.println("methodA ===>" + c.i);
	}
	public static void main(String[] args) {
		CSimulation cs = new CSimulation();
		C c = new C();
		cs.methodA(c);
		System.out.println("main===>" + c.i);
	}
}
