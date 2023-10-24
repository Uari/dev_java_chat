package _Chat.step1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class ChatServerThread extends Thread {

	ChatServer cs = null;
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String chatname = null;
	
	public ChatServerThread(ChatServer cs) {
		this.cs = cs;
		this.client = cs.socket;
		cs.jta_log.append("client" + client + "\n");
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			//100|kiwi
			String msg = (String)ois.readObject();
			cs.jta_log.append(msg+"\n"); //로그를 남긴다
			StringTokenizer st = new StringTokenizer(msg, "|");
			st.nextToken();
			chatname = st.nextToken();
			cs.jta_log.append(chatname+"님이 입장하였습니다. \n");
			
			for(ChatServerThread cst : cs.globalList) {
				System.out.println(cst.chatname);
				System.out.println(this.chatname);
				this.send(100+"|"+cst.chatname);
			}
			cs.globalList.add(this);
			this.broadCasting(msg);
			//cs.globalList.add(this);//this는 ChatServerThread이다. 
			// cs.globalList.size();
			// cs.jta_log.append("");
			//System.out.println(cs.globalList.size());
			
			
		} catch (Exception e) {

		}
		
	}

	// run메소드도 콜백메소드 - 시스템에서 대신 호출
	@Override // annotation
	public void run() {
		System.out.println("ChatSeverThread run");
		// insert here - 읽고 쓰기
		boolean isStop = false;
		String msg = null;
		try {
			start:
				while(!isStop) {
					msg = (String)ois.readObject();
					cs.jta_log.append(msg+"\n");
					//로그가 append 될때마다 스크롤바가 현재 문자열의 위치를 자동으로 인식하서 이동
					cs.jta_log.setCaretPosition(cs.jta_log.getDocument().getLength());
					StringTokenizer st = null;
					int protocol = 0;
					if(msg != null) {
						st = new StringTokenizer(msg,"|");
						protocol = Integer.parseInt(st.nextToken());
					}
					
					switch(protocol) {
					
					case 200:{//
						String nickname = st.nextToken();
						String message = st.nextToken();
						broadCasting(200+"|"+nickname+"|"+message);
					}break;
					case 500:{
						
					}break;
					
					}
				}
			
		} catch (Exception e) {

		}
	}

	// oos.writeObject(message ==>> "200|kiwi|apple|오늘 스터디?");
	public void broadCasting(String message) {
		for (ChatServerThread cst : cs.globalList) {
			cst.send(message);
			// 클라이언트 들에게 서버가 들은 메시지를 보낸다. - OutputStream
			// ObjectOutputStream oos = new ObjectOutputStream(null);
			// oos.writeObject("200|kiwi|apple|오늘 스터디?");
		}
	}
	//DM을 처리하는데 필요한 메소드를 고려하여 메소드를 하나 더 추가해본다
	public void send(String message) {
		try {
			oos.writeObject(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
