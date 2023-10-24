package com_step3;

import java.util.Scanner;

/*
 * 5와 7의 공배수
 * 35는 fizzbuzz
 */
public class FizzBuzzGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해 주세요 : ");
		int i = sc.nextInt();
		
		if ((i % 5 == 0) && (i % 7 == 0)) {
			System.out.println("fizzbuzz");
		} else if (i % 5 == 0) {
			System.out.println("fizz");
		} else if (i % 7 == 0) {
			System.out.println("buzz");
		}
	}
}
