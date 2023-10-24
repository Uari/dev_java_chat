package com_step1;

import java.util.Scanner;

public class Test1 {
	static Scanner sc = new Scanner(System.in);

	private static void insertNuum() {
		
		boolean tf = true;
		
		while(tf) {
			
			System.out.println("첫번째 수 a : ");
			int a = sc.nextInt();
			System.out.println("두번째 수 b : ");
			int b = sc.nextInt();

			System.out.println("a + b = " + (a + b));
			
			tf = breakPoint();
		}
	}
	private static boolean breakPoint() {
		System.out.println("계속하시겠숩니까? 계속 - 1 / 종료 - 3 : ");
		int c = sc.nextInt();

		if (c == 3) {
			System.out.println("종료되었습니다.");
			return false;
		}else {
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println("계산기");
		insertNuum();
	}
}
