package com_step1;

//클래스를 두 개로 쪼개본다
class A1{
	int i = 1;
}

public class ASimulation1 {

	public static void main(String[] args) {
		A1 a = new A1();
		a.i = 2;
		//내부에서 A클래스에 정의된 전역변수를 호출하기
		int j = 0;
		j = a.i;
		System.out.println(a.i);
		System.out.println(j);
		
	}
}
/*
	ASimulation.java
	A.class, ASimulation.class 클래스를 두 개 만들어짐  
*/