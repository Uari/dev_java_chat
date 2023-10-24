package com.ex6;

import java.awt.event.ActionListener;

public class SJEvent implements ActionListener {
	private SJView sjv;

	public SJEvent(SJView sjView) {

	}

	public void ActionEvent(SJView sjv) {
		this.sjv = sjv;
		sjv.jbt_clear.addActionListener(this); // 표지우기
		sjv.jbt_selectDelRow.addActionListener(this); // 선택된 행만 지우기
		sjv.jbt_process.addActionListener(this); // 처리
		sjv.jbt_add.addActionListener(this); // 처리
		sjv.jbt_exit.addActionListener(this); // 종료
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent ae) {

		// 이벤트가 발생한 컴포넌트의 주소번지 가져오기 - 어떤 버튼을 눌렀나?
		Object obj = ae.getSource();

		if (obj == sjv.jbt_process) {
			sjv.p_num = sjv.dtm.getRowCount(); // 계산할때 인원수는 현재 테이블의 행 숫자이므로
		} else if (obj == sjv.jbt_add) {
			String input[] = new String[sjv.col.length]; // 사용자값 저장할 배열 선언, col배열길이만큼
			input[0] = sjv.jt_name.getText(); // 이름 input[0]에 저장
			input[1] = sjv.jt_oracle.getText(); // 오라클점수
			input[2] = sjv.jt_java.getText(); // 자바점수
			input[3] = sjv.jt_html.getText(); // html점수

			sjv.dtm.addRow(input);

			// 입력값 저장 하고 나서 텍스트입력 칸 다시 초기화 해두기
			sjv.jt_name.setText("");
			sjv.jt_oracle.setText("");
			sjv.jt_java.setText("");
			sjv.jt_html.setText("");

		} else if (obj == sjv.jbt_selectDelRow) { // 테이블 선택했을때 .getSelectedRow() 메소드 값은 그 행의 값이 나오고
													// 아무것도 선택 안되어잇을때는 -1을 전달함.
			if (sjv.table.getSelectedRow() == -1) // -1일때(아무것도 선택되지 않았을때
			{ // if문 탈출할때 return;을 사용함
				return; // 따라서 삭제 버튼 눌렀을때 아무일도 일어나지 않는다.
			} else // 행이 선택되어있을때
			{
				sjv.dtm.removeRow(sjv.table.getSelectedRow()); // 선택된 행값을 가져와서 삭제메소드실행
			}
		} else if (obj == sjv.jbt_clear) // 전체 삭제
		{
			for (int i = sjv.dtm.getRowCount(); i > 0; i--) // 행갯수만큼 삭제메소드 반복실행
			{
				sjv.dtm.removeRow(0);
			}
		}else if (obj == sjv.jbt_exit) {
			System.exit(0); // 자바 가상머신과 연결이 끊김
		}
	}
}
