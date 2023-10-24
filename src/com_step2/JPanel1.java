package com_step2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanel1 {
	
	//setSize메소드의 파라미터는 int이다. 따라서 int타입을 선언한다
	int width = 300;
	int heigth = 500;
	boolean isView = false;

	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JTextField jtf = new JTextField("");
	
	//화면을 그리는 메소드 선언
	public void initDisplay() {
		jp.setBackground(Color.blue);
		jf.add("Center", jp);
		jf.add("South", jtf);
		jf.setSize(width, heigth);
		jf.setVisible(isView);
	}
	
	public static void main(String[] args) {
		//insert here에서 initDisplay 호출
		JPanel1 jp = new JPanel1();
		jp.isView = true;
		jp.initDisplay();
	}
}
