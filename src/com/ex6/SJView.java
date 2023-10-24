package com.ex6;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SJView {
	public SJView() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		initDisplay();
	}

	private SJEvent sje = new SJEvent(this);

	String col[] = { "이름", "오라클", "자바", "HTML", "총점", "평균", "학점", "석차" }; // 컬럼명
																			// 생성
	int p_num = 0; // 입력 받을 사람수 저장할 변수

	DefaultTableModel dtm;
	JTable table; // = new JTable(value, col); 테이블
	JScrollPane jsp; // = new JScrollPane(table); 스크롤

	JFrame jf_sungjuk = new JFrame();
	// JFrame에 붙일 속지 두 개 선언하고 생성하기
	JPanel jp_center = new JPanel();
	// 배치-jp_center 속지 중앙에 배치하자
	JPanel jp_north = new JPanel();
	JPanel jp_south = new JPanel();

	JButton jbt_clear = new JButton("전체 삭제");
	JButton jbt_selectDelRow = new JButton("선택 삭제");
	JButton jbt_add = new JButton("추가");

	// 텍스트 입력창 선언
	JTextField jt_name = new JTextField(6);
	JTextField jt_oracle = new JTextField(6);
	JTextField jt_java = new JTextField(6);
	JTextField jt_html = new JTextField(6);

	JButton jbt_process = new JButton("점수계산");
	JButton jbt_exit = new JButton("종료");

	public void initDisplay() {
		System.out.println("initDisplay 호출성공");

		jp_center.setLayout(new BorderLayout(0, 20));

		// 버튼 동작 등록
		sje.ActionEvent(this);

		jp_north.add(jbt_selectDelRow);
		jp_north.add(jbt_clear);

		// 텍스트 창 붙이기
		jp_south.add(jt_name);
		jp_south.add(jt_oracle);
		jp_south.add(jt_java);
		jp_south.add(jt_html);

		// 텍스트 입력창 초기화 부분
		jt_name.setText(""); // 이름 텍스트입력창 초기값
		jt_oracle.setText(""); // 오라클 텍스트입력창 초기값
		jt_java.setText("");
		jt_html.setText("");

		// 동작 버튼 붙이기
		jp_south.add(jbt_add);
		jp_south.add(jbt_process);
		jp_south.add(jbt_exit);

		dtm = new DefaultTableModel(col, 0); // 디폴트 테이블 생성 col 배열에 있는 값들로 컬럼이름 하고, p_num만큼 밑에 행열 생성함
		table = new JTable(dtm); // 테이블 생성(디폴트 테이블에 정해둔 값으로 생성됨)
		jsp = new JScrollPane(table); // 스크롤바 붙임
		jp_center.add("Center", jsp);
		jp_center.validate();

		jf_sungjuk.setBackground(new Color(214, 211, 206));

		// 속지 두 장을 JFrame에 붙이기
		jf_sungjuk.add("Center", jp_center);
		jf_sungjuk.add("South", jp_south);
		jf_sungjuk.add("North", jp_north);
		jf_sungjuk.setSize(600, 400);

		jf_sungjuk.setTitle("성적처리");// 메소드 구현할 때에는 타입이 오고 호출할 때에는 타입을 쓰지 않는다.
		// 호출 하는 거니까 타입이 필요가 없습니다.
		jf_sungjuk.setVisible(true);
	}
}