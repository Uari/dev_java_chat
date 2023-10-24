package com.step21;

class A { // A에는 변수만 있고
	int age = 0; // 전역변수
}

class A1 { // A1에는 메소드만 가질 수 있게 나눴다
	
	
	A a = new A();
	
	
	void methodA() {
		a.age = a.age + 1; // 1로 변한다. 그런데 이때 변경된 값은 A1 안에서만 유지된다.
	}
}

public class Amain {
	
	public static void main(String[] args) {
		 A a = new A();
		 A1 a1 = new A1();
		 
		 a1.methodA();
		 // 가설 1 - 영향이 없다.
		 
		 System.out.println(a.age); // 0이 출력될 것이다. / 1이 출력된다
	}
}