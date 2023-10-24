package com.ex4;

import java.awt.event.ActionEvent;

public class BGEvent{
	private BGService bgs;
	private BaseballGameView bgv;
	
	public BGService getBgs() {
		if(bgs == null) {
			bgs = new BGService();
		}
		return bgs;
	}
	
	public BaseballGameView getBgv() {
		if(bgv == null) {
			bgv = new BaseballGameView(this);
		}
		return bgv;
	}
	
	public BGEvent(){
		getBgv();
		getBgs();
	}

	public void actionEvent(ActionEvent e) {
		Object obj = e.getSource();
		String command = e.getActionCommand();// 이벤트 발동하는 버튼의 라벨
		if ("1".equals(command)) {
			System.out.println(command);
			bgv.ta_result.append(command);
		} else if (obj == bgv.tf_input) {
			bgv.ta_result.append(bgv.tf_input.getText() + "\n");
			bgs.gameStar();
		} else if (obj == bgv.jbtnNew) {
			bgs.gameStarView();
		} else if (obj == bgv.jbtnAnswer) {
			bgs.viewAnswer();
		} else if (obj == bgv.jbtnClear) {
			bgv.ta_result.setText("");
		} else if (obj == bgv.jbtnExit) {
			System.exit(0);
		}
	}
}
