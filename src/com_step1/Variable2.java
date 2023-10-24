package com_step1;

public class Variable2 {

	static int i = 5;
	//main메소드 선언은 static이 붙어 있으므로 non-static 타입은 호출 불가
	//해결방법 : 내안에 있는 변수라 하더라도 인스턴스화를 하면 접근 가능하다.
	int j = i;
	public static void main(String[] args) {
		
		System.out.println(i);
		//insert here
		Sonata myCar = new Sonata();
		Variable2 myNum = new Variable2();
		System.out.println(myNum.j);
		System.out.println(myCar.speed);
	}
}
