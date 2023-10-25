package network5;

import java.awt.Color;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;


public class TalkClientThread extends Thread {
	TalkClient tc = null;
	Vector<String> ve = null;
	Vector<String> v = null;

	public TalkClientThread(TalkClient tc) {
		this.tc = tc;
	}

	@Override
	public void run() {
		boolean isStop = false;

		while (!isStop) {
			StringTokenizer st = null;
			String msg = null;
			int protocol = 0;

			try {
					msg = (String) tc.ois.readObject();

				if (msg != null) {
					st = new StringTokenizer(msg, "|");
					protocol = Integer.parseInt(st.nextToken());
				}
				
				switch (protocol) {
				//접속
				case 100: {
					String nickname = st.nextToken();
					tc.jta_display.append(nickname+"님이 접속하셨습니다. \n");
					v = new Vector<>();
					v.add(nickname);
					tc.dtm.addRow(v);
				}break;
				//대화전송
				case 201:{
					String nickname = st.nextToken();
					String message = st.nextToken();
					
					tc.jta_display.append("["+nickname+"] "+message+"\n");
					tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
				}break;
				//대화명 변경 
				case 202:{
					String nickname = st.nextToken();
					String aftername = st.nextToken();
					String message = st.nextToken();
					
					if(nickname.equals(tc.nickName)) {
						//닉네임 변경
						tc.nickName = aftername;
						//채팅창에 타이틀바에도 대화명을 변경처리 한다.
						tc.setTitle(tc.nickName+"님의 대화방");
					}
					//테이블 닉네임 변경
					for(int i =0; i<tc.dtm.getRowCount(); i++) {
						if(nickname.equals((String)tc.dtm.getValueAt(i, 0))) {
							tc.dtm.setValueAt(aftername, i, 0);
							break;
						}
					}
					tc.jta_display.append(message);
					tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
				}break;
				//대화방 나가기
				case 500:{
					String nickname = st.nextToken();
					String exitMsg = st.nextToken();
					
					//접속자 테이블에서 제거 
					for(int i = 0; i<tc.dtm.getRowCount(); i++) {
						if(nickname.equals((String)tc.dtm.getValueAt(i, 0))) {
							tc.dtm.removeRow(i);
						}
					}
					tc.jta_display.append(exitMsg);
					tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
				}break;
				//글자색 변경
				case 203:{
					Color fontColor = null;
					String nickname = st.nextToken();
					String selectFontColor = st.nextToken();
					
					switch (selectFontColor) {
					case "Red": {
						fontColor = Color.red;
					}break;
					case "Blue":{
						fontColor = Color.blue;
					}break;
					case "Green":{
						fontColor = Color.green;
					}break;
					case "Black":{
						fontColor = Color.black;
					}break;
					}
					tc.jta_display.setForeground(fontColor);
				}break;
				
				case 200:{
					tc.initDisplay2();
					String nickname = st.nextToken();
					String selectedNickname = st.nextToken();
					
					tc.mjta_display.append(nickname+"님이 접속하셨습니다. \n");
					tc.mjta_display.append(selectedNickname+"님이 접속하셨습니다. \n");
					ve = new Vector<>();
					ve.add(nickname);
					tc.mdtm.addRow(ve);
					ve = new Vector<>();
					ve.add(selectedNickname);
					tc.mdtm.addRow(ve);
					
				}break;
				case 301:{
					String nickname = st.nextToken();
					String message = st.nextToken();
					
					tc.mjta_display.append("["+nickname+"] "+message+"\n");
					tc.mjta_display.setCaretPosition(tc.mjta_display.getDocument().getLength());
				}break;
				case 600:{
					String nickname = st.nextToken();
					String exitMsg = st.nextToken();
					
					//접속자 테이블에서 제거 
					for(int i = 0; i<tc.mdtm.getRowCount(); i++) {
						if(nickname.equals((String)tc.mdtm.getValueAt(i, 0))) {
							tc.mdtm.removeRow(i);
							ve.removeAllElements();
							System.out.println(ve);
						}
					}
					tc.mjta_display.append(exitMsg);
					tc.mjta_display.setCaretPosition(tc.mjta_display.getDocument().getLength());
				}
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
