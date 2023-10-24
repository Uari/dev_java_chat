package com.step21;

import java.util.Scanner;

class E{
	Scanner sc = new Scanner(System.in);
	//getFirst메소드를 선언해서 사용자로 부터 숫자를 입력받는 메소드를 구현해 보시오.
	public int getFirst() {
		int num = 0;
		System.out.println("숫자를 입력하세요 : ");
		num = sc.nextInt();
		return num;
	}
}
public class Emain {

	public static void main(String[] args) {
		E e = new E();
		System.out.println("입력 받은 숫자는 : " + e.getFirst());
	}
}
/*
 예제)
 0~9사이의 임의 숫자를 채번하고(랜덤하게 찍는다)
 사용자로 부터 숫자를 입력받아서 입력받은 숫자가 더 작으면 힌트를 높여라라고 출력하고
 더 크면 낮춰라 라고 힌트를 주어서 5번 까지만 기회를 제공해서 그 숫자를 맞추는 게임을 작성해 보시오.
 
 램덤 메서드 조건문 반복문 Scanner 
*/
