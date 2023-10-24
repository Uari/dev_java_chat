package com.ex9;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChattingView {
	
	JFrame jf = new JFrame();
	JButton btnWrite = new JButton("전송");
	JEditorPane je = new JEditorPane();
	JPanel jp = new JPanel();
	JTextArea jta = new JTextArea();
	
	public ChattingView() {
		initDisPlay();
	}
	public void initDisPlay() {
		jf.setTitle("Chatting");
		jf.add("Center", jta);
		jf.add("South", jp);
		jp.add("West", je);
		jp.add("East", btnWrite);
		jf.setSize(500,600);
		jf.setVisible(true);
	}
}
