package com_step2;


import javax.swing.JFrame;

public class JPanel2 {
	JFrame jf = new JFrame();

	//자바에서는 같은 이름의 메소드를 중복 선언할 수 있다.
	//메소드 오버로딩 검색해 본다
	public void initDisplay(int width, int height, boolean isView) {
		jf.setSize(width, height);
		jf.setVisible(isView);
	}
	
	public void initDisplay(int width, int height) {
		jf.setSize(width, height);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		//insert here에서 initDisplay 호출
		JPanel2 jp = new JPanel2();
		int width = 600;
		int height = 500;
		boolean isview = true;
		//jp.initDisplay(width, height, isview);
		jp.initDisplay(width, height);
	}
}
