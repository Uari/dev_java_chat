package com_step4;

class Dept{
	public Dept(Deptmain deptmain) {
		System.out.println(deptmain);
	}
	
}

public class Deptmain {
	int a = 1;
	Dept de = new Dept(this);
	public Deptmain() {
		System.out.println("111");
		System.out.println(a);
	}

	public static void main(String[] args) {
		Deptmain d = new Deptmain();
	}
}
