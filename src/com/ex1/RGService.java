package com.ex1;

import java.util.Random;
import java.util.Scanner;

public class RGService {

	// 난수 생성
	public int randomNum() {
		RGVo evo = new RGVo();
		Random r = new Random();
		
		evo.setRandomNum(r.nextInt(10));

		return evo.getRandomNum();
	}

	// 게임메소드
	public void game(int rNum) {
		int uNum = 0;
		// 사용자로 부터 입력을 받는다
		Scanner sc = new Scanner(System.in);

		int i;
		for (i = 0; i < 5; i++) {
			System.out.print("숫자를 입력하세요 (0~9) : ");
			uNum = sc.nextInt();
			//sc.close();
			if ((uNum > 9) || (uNum < 0)) {
				System.out.println("0~9사이의 숫자를 입력하세요...");
				i = 0;
			} else {

				if (rNum == uNum) {
					System.out.println("축하합니다. 게임에서 승리하셨습니다!!");
					System.out.println("==============================  게임종료  ==============================");
					break;
				} else if (uNum < rNum) {
					System.out.println("입력하신 숫자보다 큽니다.");
				} else {
					System.out.println("입력하신 숫자보다 작습니다.");
				}
			}
		}
		if (i == 5) {
			System.out.println("게임 오버 다시한번 도전해 보세요");
		}
		
	}
}
