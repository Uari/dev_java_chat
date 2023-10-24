package com.ex1;

import java.util.Scanner;

/*
예제)
0~9사이의 임의 숫자를 채번하고(랜덤하게 찍는다)
사용자로 부터 숫자를 입력받아서 입력받은 숫자가 더 작으면 힌트를 높여라라고 출력하고
더 크면 낮춰라 라고 힌트를 주어서 5번 까지만 기회를 제공해서 그 숫자를 맞추는 게임을 작성해 보시오.

랜덤 메서드 조건문 반복문 Scanner 
*/

public class RandomGame {
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  

	public static void main(String[] args) {
		RGService sv = new RGService();
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		int rNum = 0;
		
		System.out.println("====================== Random 게임 ======================");
		
		while(true) {
			System.out.println("1. 게임시작 | 2. 정답보기 | 3. 게임종료");
			System.out.print("메뉴를 선택 하세요 : ");
			menu = sc.nextInt();
			//sc.close();
			if(menu == 1) {
				rNum = sv.randomNum();
				sv.game(rNum);
				break;
			}else if(menu == 2) {
				System.out.println("정담 : " + sv.randomNum());
			}else if(menu == 3) {
				System.out.println("==============================  게임종료  =================================");
				break;
			}else {
				System.out.println("숫자를 잘못 입력 하셨습니다. 다시 선택하여 주세요...");
			}
		}
	}
}
