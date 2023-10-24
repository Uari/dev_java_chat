package com_step1;

public class Variable3 {
	
	//변수 선언
	
	
	public void account(int i, int j) { //파라미터 자리에 선언된 변수는 지역변수 이다 - 값이 결정되지 않았다.
		System.out.println("account 성공");
		System.out.println(i);
		System.out.println(j); //call by value
	}
	
	public static void main(String[] args) {
		//타입결정 , 변수 개수 결정 해야 한다.

		//static영역안에서 static이 없는 메소드를 호출하려면
		//반드시 인스턴스화를 할 것 
		
		//account 호출하기
		Variable3 v3 = new Variable3();
		v3.account(1, 2); //-> 호출할 때 파라미터 값 결정 (초기화) / 지역변수는 초기화 생력할 수 없다.
		
	}
}
