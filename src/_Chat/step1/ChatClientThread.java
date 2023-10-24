package _Chat.step1;

import java.util.StringTokenizer;
import java.util.Vector;

//서버가 한 말을 듣는 클래스 설계
public class ChatClientThread extends Thread {
	ChatClient cc = null;

	public ChatClientThread(ChatClient cc) {
		this.cc = cc;
	}

	//말하기는 ChatClient의 actionPerformed에서 JTextField에 엔터 폈을 때 처리한다
	@Override
	public void run() {
		boolean isStop = false;
		start:
		while (!isStop) {
			try {
				String msg = "";
				msg = (String) cc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0; // 100|200|500(나가기)
				if (msg != null) {
					st = new StringTokenizer(msg, "|");
					protocol = Integer.parseInt(st.nextToken());// 100
				}
				
				switch (protocol) {
				case 100: {
					String nickname = st.nextToken();
					cc.jta_display.append(nickname + "민이 입장하셨습니다.\n");
					Vector<String> v = new Vector<>();
					v.add(nickname);
					cc.dtm.addRow(v);
				}break;
				case 200:{//다자간 대화
					String nickname = st.nextToken();
					String message = st.nextToken();
					cc.jta_display.append("["+ nickname +"]"+message+"\n");
					cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				}break;
				case 500:{//나가기
					
				}break start;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
