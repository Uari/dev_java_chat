package com_step1;

public class Static1 {

	int i = 1;
	static int j = 2; //정적변수 - 클래스 급 - 하나만 생성됨(하나를 공유하는 개념)
	public double d = 0.5;
	
	public void methodA() {
		System.out.println("methodA 호출 성공"); 
	}
	public static void methodB() {
		System.out.println("methodB 호출 성공");
	}
	public static void main(String[] args) {
		Static1 s = new Static1();
		System.out.println(s.i);
		//변수 j선언시 static을 붙였으므로 인스턴스 변수 없이도 직접 호출이 가능함
		System.out.println(j); //j는 인스턴스화 없이도 호출이 가능함
		System.out.println(s.d);
		
		s.methodA();
		methodB();
	}
}
