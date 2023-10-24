package com.step5;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Reload1 extends JFrame implements ActionListener{
	//선언부
	JPanel jp = new JPanel();
	JButton jbtnNew = new JButton("새로고침");
	JButton jbtn = new JButton("조회");
	//생성부
	
	//화면처리
	public void initDisplay() {
		jbtnNew.addActionListener(this);
		jp.setBackground(Color.red);
		this.add("North", jbtnNew);
		this.add("Center", jp);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	
	//메인메소드
	public static void main(String[] args) {
		Reload1 r = new Reload1();
		r.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtnNew) {
			Container cp = this.getContentPane();
			cp.remove(jp);
			JPanel jpCopy = null;
			jp = null;
			jp = new JPanel();
			jpCopy = jp;
			jpCopy.setBackground(Color.yellow);
			this.add("Center", jpCopy);
			this.revalidate();
			this.repaint();
		}
	}
}
