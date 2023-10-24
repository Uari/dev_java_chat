package com.step6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*SELECT empno, ename
FROM emp
WHERE empno =: x; --파라미터자리
업무에 따라 집합이름과 컬럼명만 바뀐다. 나머지는 다 그대로 이다. - syntax -문법

 1. parsing한다.
 2. DBMS에게 실행계획을 받아낸다.
 3. 옵티마이저가 실행계획에 따라 처리하기
 4. open..cursor..fetch..close
*/
public class Annoymous1 extends JFrame {
	
	JButton jbtn = new JButton("조회");
	public Annoymous1() {
		jbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("조회");
			}
		});
		this.add("North", jbtn);
		this.setSize(500,400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Annoymous1();
	}
}
