package com.step00;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//클래스 선언하기
//ActionListener는 인터페이스 이라서 추상메소드를 가지고 있다.
//추상메소드란 선언만 되어있고 좌중괄호와 우중괄호가 없는 메소드 말함
public class AddressBook implements ActionListener{
	//선언부
	JFrame jf = new JFrame();
	JPanel jp_north = new JPanel();//버튼 4개 배치하는데 사용함-단독으로 모양이 없다
	JButton btnSelect = new JButton("조회");
	JButton btnInsert = new JButton("입력");
	JButton btnUpdate = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	//생성자
	public AddressBook() {}
	//화면처리 구현
	public void initDisplay() {
		//이벤트 처리 3단계 -  버튼의 이벤트를 지원하는 인터페이스를 implements한다. - ActionListener
		//해당 인터페이스가 선언하고 있는 메소드를 오버라이딩 해야한다. - actionPerformed(ActionEvent e)
		//이벤트소스와 이벤트 처리를 담당하는 클래스를 매칭해줌
		btnSelect.addActionListener(this);
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		jp_north.add(btnSelect);
		jp_north.add(btnInsert);
		jp_north.add(btnUpdate);
		jp_north.add(btnDelete);
		jf.add("North", jp_north);
		jf.setTitle("주소록 Ver1.0");
		jf.setSize(800,500);
		jf.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		AddressBook abook = new AddressBook();//기본
		abook.initDisplay();
	}
	//아래 메소드는 ActionListener인터페이스에 이름이 정해져 있다.
	//구현체 클래스인 너가 재정의하여 구현해라
	@Override
	public void actionPerformed(ActionEvent e) {
		BGEvent bge = new BGEvent();
		bge.actionEvent(e);
	}
}