package com.ex5BaseBallGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;

public class BaseballGameView extends JFrame {
	
	private BGEvent bge = new BGEvent(this);
	private BGService bgs = new BGService(this);

	JPanel p_center = new JPanel();
	JPanel p_east = new JPanel();
	JPanel p_south = new JPanel();
	JTextArea ta_result = new JTextArea();
	JTextField tf_input = new JTextField("", 80);
	JButton jbtnNew = new JButton("새게임");
	JButton jbtnAnswer = new JButton("정답보기");
	JButton jbtnClear = new JButton("지우기");
	JButton jbtnExit = new JButton("종료하기");
	
	public BaseballGameView() {
		initDisplay();
	}

	public void initDisplay() {
		bgs.gameStarView();
		// 버튼 액션 이벤트
		bge.btnEvent(bgs);

		p_center.setLayout(new FlowLayout());
		p_center.setBackground(Color.white);
		p_center.add("Center", ta_result);
		p_south.add("South", tf_input);
		p_east.setBackground(Color.white);
		p_east.setLayout(new GridLayout(4, 1, 2, 2));
		p_east.add(jbtnNew);
		p_east.add(jbtnAnswer);
		p_east.add(jbtnClear);
		p_east.add(jbtnExit);

		this.add("Center", p_center);
		this.add("East", p_east);
		this.add("South", p_south);
		this.setTitle("숫자맞추기게임");
		this.setSize(1000, 800);
		this.setVisible(true);
		tf_input.setFocusable(true);
		tf_input.requestFocus();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
