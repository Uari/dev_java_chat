package com.ex8SocketTime;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeView {
	
	JFrame jf = new JFrame();
	Font ft = new Font("똗음체", Font.BOLD, 30);
	JLabel jlt = new JLabel("현재시간", JLabel.CENTER);
	TimeClient tc = new TimeClient(this);
	
	public TimeView() {
		initDisplay();
	}
	
	public void initDisplay() {
		jlt.setFont(ft);
		jf.add("North", jlt);
		jf.setSize(700, 400);
		jf.setVisible(true);
	}
}
