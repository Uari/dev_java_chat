package com_step4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
	JFrame jf = new JFrame();
	JButton jp = new JButton("ss");

	public View() {
		new Logic(this);
		jf.setSize(300, 300);
		jf.setVisible(true);
	}

	public static void main(String[] args) {

		View v = new View();
	}
}
