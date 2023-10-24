package com.ex2;

import java.util.Random;
import java.util.Scanner;

public class BGService {

	// 메인메뉴 화면
	public void bgMainmeuSelect() {
		System.out.println();
		System.out.println("  1. 게임사작  |  2. 정답확인  |  3. 게임종료  ");
	}

	// 게임 시작 메소드
	public void gameStart(BGVo bgvo) {
		Scanner sc = new Scanner(System.in);

		int rNum = bgvo.getRandomNum();
		int uNum = 0;

		while (true) {
			System.out.print("세자리 숫자를 입력해 주세요 (100~999) : ");
			uNum = sc.nextInt();

			// User는 세자리 숫자만 입력이 가능하다
			if (uNum < 99) {
				System.out.println("!!!!!!!!!! 경고 !!!!!!!!!!!");
				System.out.println("!!  세자리 숫자를 입력해 주세요   !! ");
				System.out.println("!!!!!!!!!! 경고 !!!!!!!!!!!");
				System.out.println();
			} else {
				// 문자 하나하나 비교하기 위해 문자열로 변경
				String strRNum = String.valueOf(rNum);
				String strUNum = String.valueOf(uNum);

				int strike = 0;
				int ball = 0;

				if (rNum == uNum) {
					System.out.println(" ## 축하합니다!! 게임에서 승리 하셨습니다!!!!!  ##");
					break;
				} else {
					for (int i = 0; i < strRNum.length(); i++) {
						if (strRNum.charAt(i) == strUNum.charAt(i)) {
							strike++;
						} else {
							for (int j = 0; j < strUNum.length(); j++) {
								if (strRNum.charAt(i) == strUNum.charAt(j)) {
									ball++;
								}
							}
						}
					}
				}
				System.out.println("  strike : " + strike + "  ball : " + ball);
			}
		}
	}

	// 랜덤 난수 생성하기
	public void setRandomNum(BGVo bgvo) {
		Random r = new Random();
		int rNum = r.nextInt(1000);
		String rmDud = String.valueOf(rNum);

		for (int i = 0; i < rmDud.length(); i++) {
			for (int j = 0; j < rmDud.length(); j++) {
				if (i != j) {
					//세자리
					if (rNum < 100) {
						rNum = r.nextInt(1000);
						rmDud = String.valueOf(rNum);
						i = 0;
						break;
					//중복제거
					} else if (rmDud.charAt(i) == rmDud.charAt(j)) {
						rNum = r.nextInt(1000);
						rmDud = String.valueOf(rNum);
						i = 0;
						break;
					}
				}
			}
		}
		bgvo.setRandomNum(rNum);
	}

	// 정답 확인
	public void viewAnswer(BGVo bgvo) {
		int rNum = bgvo.getRandomNum();

		System.out.println("정답은 : " + rNum + "입니다.");
	}
}
