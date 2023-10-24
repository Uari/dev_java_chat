package com.week3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcView implements ActionListener{
	JFrame jf = new JFrame();
	JTextField jtf_display = new JTextField("0");
	JPanel jp = new JPanel();
	JButton jbtnOne = new JButton("1");
	JButton jbtnTwo = new JButton("2");
	JButton jbtnPlus = new JButton("+");
	JButton jbtnEqual = new JButton("=");
	JButton jbtnBack = new JButton("<=");
	JButton jbtnClear = new JButton("C");
	String v1 = "";
	String v2 = "";
	String op = "";
	
	public void initDisplay() {
		jtf_display.setHorizontalAlignment(JTextField.RIGHT);
		jbtnOne.addActionListener(this);
		jbtnTwo.addActionListener(this);
		jbtnPlus.addActionListener(this);
		jbtnEqual.addActionListener(this);
		jbtnBack.addActionListener(this);
		jbtnClear.addActionListener(this);
		jp.add(jbtnOne);
		jp.add(jbtnTwo);
		jp.add(jbtnPlus);
		jp.add(jbtnEqual);
		jp.add(jbtnBack);
		jp.add(jbtnClear);
		jf.add("North",jtf_display);
		jf.add("Center",jp);
		jf.setSize(400, 400);
		jf.setVisible(true);
	}
	
	public String calcurate(String v1, String v2, String op) {
		double d1 = Double.parseDouble(v1);
		double d2 = Double.parseDouble(v2);
		if("+".equals(op)) {
			return String.valueOf(d1+d2);
		}
		else if("-".equals(op)) {
			return String.valueOf(d1-d2);
		}
		else if("*".equals(op)) {
			return String.valueOf(d1*d2);
		}
		else if("/".equals(op)) {
			return String.valueOf(d1/d2);
		}
		else {
			return "error";
		}
	}
	
	public static void main(String[] args) {
		CalcView cv = new CalcView();
		cv.initDisplay();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if("1".equals(command)) {
			if("0".equals(jtf_display.getText())) {
				jtf_display.setText("");
			}
			jtf_display.setText(jtf_display.getText()+"1");
		}
		else if("2".equals(command)) {
		
			if("0".equals(jtf_display.getText())) {
				jtf_display.setText("");
			}
			jtf_display.setText(jtf_display.getText()+"2");			
		}
		else if("+".equals(command)) {
			System.out.println("더하기 버튼");
			
			v1 = jtf_display.getText();
			System.out.println("v1 :"+v1);
			op="+";
			jtf_display.setText("");
		}
		else if("=".equals(command)) {
			System.out.println("계산 결과는 얼마");			
			v2 = jtf_display.getText();
			String result = calcurate(v1,v2,op);
			jtf_display.setText(result);
		}		
		else if("<=".equals(command)) {
			System.out.println("한글자씩 지우기 구현");		
		}		
		else if("C".equals(command)) {
			jtf_display.setText("");
		}		
	}
}







