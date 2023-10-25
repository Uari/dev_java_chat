package network5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
	TalkServer ts = null;
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String chatName = null;// 현재 서버에 입장한 클라이언트 스레드 닉네임 저장
	String chatName2 = null;
	String charName3 = null;

	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		this.client = ts.socket;

		try {
			String msg = null;
			// 쓰고 읽기
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			// 메세지 불러오기
			msg = (String)ois.readObject();
			ts.jta_log.append(msg + "\n");
			// 메세지 쪼개기 & 닉네임 저장
			StringTokenizer st = new StringTokenizer(msg, "|");
			st.nextToken(); // 앞에 숫자 빼기
			chatName = st.nextToken(); // 닉네임 저장
			ts.jta_log.append(chatName + "님이 입장하였습니다.\n");
			// 이전에 입장해 있는 친구들 정보 받아내기
			for (TalkServerThread tst : ts.globalList) {
				this.send(100 + "|" + tst.chatName);
			}
			// 현재 서버에 입장한 클라이언트 스레드 추가하기
			ts.globalList.add(this);
			this.broadCasting(msg);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
	public void broadCasting(String msg) {
		for (TalkServerThread tst : ts.globalList) {
			tst.send(msg);
		}
	}
	//1:1 메세지 전송
	public void oneCasting(String msg) {
		for (TalkServerThread tst : ts.globalList2) {
			System.out.println("oneCast"+tst);
			tst.send(msg);
		}
	}
	public void oneInit(String msg) {
		StringTokenizer st = new StringTokenizer(msg, "|");
		st.nextToken();
		chatName2 = st.nextToken();
		charName3 = st.nextToken();
		int rowRum = Integer.parseInt(st.nextToken());
		int selectedRowRum = Integer.parseInt(st.nextToken());
		
		for (TalkServerThread tst : ts.globalList) {
			if(tst.equals(ts.globalList.get(rowRum))) {
				ts.globalList2.add(tst);
			}else if(tst.equals(ts.globalList.get(selectedRowRum))){
				ts.globalList2.add(tst);
			}
		}
		for (TalkServerThread tst : ts.globalList2) {
			System.out.println("oneInit"+tst);
			tst.send(msg);
		}
	}

	// 클라이언트에게 말하기 구현
	public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String msg = null;
		boolean isStop = false;
		try {
			StringTokenizer st = null;
			int protocol = 0;
			
			run_start: while (!isStop) {
				msg = (String) ois.readObject();
				ts.jta_log.append(msg + "\n");
				ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
				
				if (msg != null) {
					st = new StringTokenizer(msg, "|");
					protocol = Integer.parseInt(st.nextToken());// 100
				}
				// 100|200|201|202|500
				switch (protocol) {
				case 201: {
					String nickName = st.nextToken();
					String message = st.nextToken();
					broadCasting(201 + "|" + nickName + "|" + message);
				}break;
				case 202: {
					String nickName = st.nextToken();
					String afterName = st.nextToken();
					String message = st.nextToken();
					this.chatName = afterName;
					broadCasting(202 + "|" + nickName + "|" + afterName + "|" + message);
				}break;
				case 500: {
					String nickName = st.nextToken();
					String exitMsg = st.nextToken();
					ts.globalList.remove(this);
					broadCasting(500 + "|" + nickName + "|" +exitMsg);
				}break run_start;
				case 203:{
					String nickname = st.nextToken();
					String selectFontColor = st.nextToken();
					broadCasting(203 + "|" + nickname + "|" +selectFontColor);
				}break;
				case 200:{
					String nickname = st.nextToken();
					String selectedName = st.nextToken();
					String rowNum = st.nextToken();
					String selectRowNum = st.nextToken();
					//int selectedRowNum = Integer.parseInt(st.nextToken());
					oneInit(200 + "|" + nickname + "|"+selectedName+"|"+rowNum+"|"+selectRowNum);
					//broadCasting(200 + "|" + nickname + "|" +selectedName);
				}break;
				case 301:{
					String nickName = st.nextToken();
					String message = st.nextToken();
					oneCasting(301 + "|" + nickName + "|" + message);
				}break;
				case 600:{
					String nickName = st.nextToken();
					String exitMsg = st.nextToken();
					ts.globalList2.remove(this);
					oneCasting(600 + "|" + nickName + "|" +exitMsg);
				}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
