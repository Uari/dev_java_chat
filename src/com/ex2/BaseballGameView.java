package com.ex2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;

public class BaseballGameView extends JFrame  implements ActionListener{
	BGService bgs = new BGService();
	BGVo bgvo = new BGVo();
	
	JPanel p_center = new JPanel();
	JPanel p_east = new JPanel();
	JPanel p_south = new JPanel();
	JTextArea ta_result = new JTextArea();
	JTextField tf_input = new JTextField("", 80);
	JButton jbtnNew = new JButton("새게임");
	JButton jbtnAnswer = new JButton("정답보기");
	JButton jbtnClear = new JButton("지우기");
	JButton jbtnExit = new JButton("종료하기");
	Font f = new Font("Thoma", Font.BOLD, 18);
	
	public BaseballGameView() {
		initDisplay();
	}

	public void initDisplay() {
		tf_input.addActionListener(this);
		jbtnNew.addActionListener(this);
		p_center.setLayout(new FlowLayout());
		p_center.setBackground(Color.black);
		p_center.add("Center", ta_result);
		p_south.add("South", tf_input);
		p_east.setBackground(Color.white);
		p_east.setLayout(new GridLayout(4,1,2,2));
		
		p_east.add(jbtnNew);
		p_east.add(jbtnAnswer);
		p_east.add(jbtnClear);
		p_east.add(jbtnExit);
		
		this.add("Center", p_center);
		this.add("East", p_east);
		this.add("South", p_south);
		this.setTitle("숫자맞추기게임");
		this.setSize(1000,800);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String command = e.getActionCommand();//이벤트 발동하는 버튼의 라벨
		if("1".equals(command)) {
			System.out.println(command);
			ta_result.append(command);
		}else if(obj == tf_input) {
			ta_result.append(tf_input.getText()+"\n");
			tf_input.setText("");
		}else if(obj == jbtnNew) {
			//bgs.gameStart(bgvo);
		}
	}
}
