package com.ex4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;

public class BaseballGameView extends JFrame implements ActionListener {
	private BGService bgs;
	private BGEvent bge;
	
	public BGService getBgs() {
		if(bgs == null) {
			bgs = new BGService();
		}
		return bgs;
	}
	
	public BGEvent getBge() {
		if(bge == null) {
			bge = new BGEvent();
		}
		return bge;
	}

	public BaseballGameView() {
		getBge();
		getBgs();
		initDisplay();
	}


	public BaseballGameView(BGEvent bge) {
		this.bge = bge;
	}


	JPanel p_center = new JPanel();
	JPanel p_east = new JPanel();
	JPanel p_south = new JPanel();
	JTextArea ta_result = new JTextArea();
	JTextField tf_input = new JTextField("", 80);
	JButton jbtnNew = new JButton("새게임");
	JButton jbtnAnswer = new JButton("정답보기");
	JButton jbtnClear = new JButton("지우기");
	JButton jbtnExit = new JButton("종료하기");

	public void initDisplay() {
		bgs.gameStarView();
		
		// 버튼 액션 이벤트
		tf_input.addActionListener(this);
		jbtnNew.addActionListener(this);
		jbtnAnswer.addActionListener(this);
		jbtnClear.addActionListener(this);
		jbtnExit.addActionListener(this);

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		bge.actionEvent(e);
	}
}
