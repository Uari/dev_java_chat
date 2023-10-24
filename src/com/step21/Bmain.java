package com.step21;

class B {
	
	int age = 0;

}

class B1 {
// 메소드의 파라미터를 통해서 복사본 대신 원본을 넘겨서 그 원본이 가리키는 전변의 값을 출력한다
	
	B a = new B();
	
	void methodA(B b) {
		b.age = b.age + 1;
	}
}
public class Bmain {
	public static void main(String[] args) {
		 
		 B a = new B();
		 B1 a1 = new B1();
		 
		 a1.methodA(a);
		 
		 System.out.println(a.age);
	}
}