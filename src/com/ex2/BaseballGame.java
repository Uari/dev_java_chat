package com.ex2;

import java.util.Scanner;

/*
 * 숫자야구 게임
 * ex)
 * 정답 : 257
 * 
 * 1. 329 : 0스 1볼
 * 2. 529 : 0스 2볼
 * 3. 259 : 2스 0볼
 */
public class BaseballGame {

	public static void main(String[] args) {
		// new BaseballGameView();

		BGService bgs = new BGService();
		BGVo bgvo = new BGVo();
		Scanner sc = new Scanner(System.in);

		int selectMenu = 0; // 메뉴 선택 변수
		boolean switchBoolean = true; // while문 종료 변수

		while (switchBoolean) {
			System.out
					.println("======================================  숫자야구 게임  ======================================");
			bgs.setRandomNum(bgvo); // 랜덤수 생성
			bgs.bgMainmeuSelect(); // 메인메뉴 선택화면
			selectMenu = sc.nextInt();

			switch (selectMenu) {
			case 1:
				bgs.gameStart(bgvo);
				break;
			case 2:
				bgs.viewAnswer(bgvo);
				break;
			case 3:
				switchBoolean = false;
				System.out.println(
						"\"======================================  게임종료  ======================================\"");
				break;
			default:
				System.out.println("메뉴를 다시 입력해 주세요...");
			}
		}

	}
}
