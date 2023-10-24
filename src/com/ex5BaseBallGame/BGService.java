package com.ex5BaseBallGame;

import java.util.Random;

public class BGService {
	private BGVO bgvo = new BGVO();
	private BaseballGameView bgv;
	
	public BGService(BaseballGameView bgv) {
		this.bgv = bgv;
	}

	public void gameStarView() {
		bgvo.setCnt(0);
		setRandomNum();
		bgv.ta_result.setText("========================  숫자야구 게임  ======================== \n");
		bgv.ta_result.append("세자리 숫자를 입력해 주세요 (100~999) : \n");
	}

	// 게임 시작 메소드
	public void gameStar() {
		int cnt = bgvo.getCnt();
		int rNum = bgvo.getRandomNum();
		String uNum = null;

		uNum = bgv.tf_input.getText();
		bgv.tf_input.setText("");

		// User는 세자리 숫자만 입력이 가능하다
		if (uNum.length() != 3) {
			bgv.ta_result.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 경고 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
			bgv.ta_result.append("!!!!!!!  세자리 숫자를 입력해 주세요   !!!!!!! \n");
			bgv.ta_result.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 경고 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
			bgv.ta_result.append("\n");
		} else {
			// 문자 하나하나 비교하기 위해 문자열로 변경
			String strRNum = String.valueOf(rNum);
			bgvo.setCnt(++cnt);
			int strike = 0;
			int ball = 0;

			if (strRNum.equals(uNum)) {
				bgv.ta_result.append(" ## 축하합니다!! 게임에서 승리 하셨습니다!!!!!  ##\n");
				// break;
			} else {
				for (int i = 0; i < strRNum.length(); i++) {
					if (strRNum.charAt(i) == uNum.charAt(i)) {
						strike++;
					} else {
						for (int j = 0; j < uNum.length(); j++) {
							if (strRNum.charAt(i) == uNum.charAt(j)) {
								ball++;
							}
						}
					}
				}
				bgv.ta_result.append("| " + cnt + "회차 | strike : " + strike + "  ball : " + ball + "\n");
			}
		}
	}

	// 랜덤 난수 생성하기
	public void setRandomNum() {
		Random r = new Random();
		int rNum = r.nextInt(1000);
		String rmDud = String.valueOf(rNum);

		for (int i = 0; i < rmDud.length(); i++) {
			for (int j = 0; j < rmDud.length(); j++) {
				if (i != j) {
					// 세자리
					if (rNum < 100) {
						rNum = r.nextInt(1000);
						rmDud = String.valueOf(rNum);
						i = 0;
						break;
					// 중복제거
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
	public void viewAnswer() {
		int rNum = bgvo.getRandomNum();
		bgv.ta_result.append("정답은 : " + rNum + "입니다.\n");
	}
}
