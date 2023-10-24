package com_step1;

public class Double3 {

	public static void main(String[] args) {
		int i = 1;
		
		//정수는 실수에 담을 수 있다.
		double d = 3.14;
		i = (int)d;  // 캐스팅 연산자 -> 강제 형변환 연산자
		//대입연산자 오른쪽에는 왼쪽에 온 타입보다 큰 타입은 불가함
		//i = d; //double이 더 큰 범위라서 치환이 안됨
		System.out.println(i);
		System.out.println(d);
	}
}
