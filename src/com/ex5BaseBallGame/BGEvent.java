package com.ex5BaseBallGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BGEvent implements ActionListener {
	private BGService bgs;
	private BaseballGameView bgv;

	public BGEvent(BaseballGameView bgv) {
		this.bgv = bgv;
	}

	public void btnEvent(BGService bgs) {
		this.bgs = bgs;
		bgv.tf_input.addActionListener(this);
		bgv.jbtnNew.addActionListener(this);
		bgv.jbtnAnswer.addActionListener(this);
		bgv.jbtnClear.addActionListener(this);
		bgv.jbtnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//String command = e.getActionCommand();// 이벤트 발동하는 버튼의 라벨
		if (obj == bgv.tf_input) {
			bgv.ta_result.append(bgv.tf_input.getText() + "  :  ");
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
