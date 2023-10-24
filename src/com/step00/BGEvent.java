package com.step00;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class BGEvent{
	
	public void actionEvent(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		
	}
}
