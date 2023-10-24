package com.step6;

public class Super2 extends Super1 {
	int b = 2;
	void methodB() {
		//같은 클래스 내에 선언된 변수가 아니더라도 상속받은 부모 클래스의 선언된 변수는 호출 가능
		System.out.println(a);
		System.out.println("methodB 호출");
	}
	//Super2클래스를 상속받는 클래스에서는 methodB와 methodC
	public void methodC() {
		System.out.println("Super2: methodC() 호출");
	}
}
