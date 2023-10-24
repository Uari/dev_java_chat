package com_step3;

import java.util.Scanner;

//1~n까지의 홀수의 합을 구하는 프로그램을 작성
public class For3 {

	public static void main(String[] args) {
		int n = 0; //사용자가 입력한 수를 담는 변수
		int sum = 0;
		int sum2 = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("n의 숫자를 입력해 주세요 : ");
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			if(i%2==1) {
				sum += i;
			}else {
				sum2 += i;
			}
		}
		System.out.println("1~"+n+"까지 숫자의 홀수의 합은 : " + sum);
		System.out.println("1~"+n+"까지 숫자의 짝수의 합은 : " + sum2);
		
	}
}
