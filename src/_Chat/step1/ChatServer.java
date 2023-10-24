package _Chat.step1;

import java.awt.Color;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


//스레드를 상속받는 이유?
//화면을 처리하는 메인메소드와 통신채널을 설정하는 스레드를 분리
public class ChatServer extends Thread {
	
	/* 선언부 */
	List<ChatServerThread> globalList = null;
	ServerSocket server = null;
	Socket socket = null;
	
	JFrame jf = new JFrame();
	JTextArea jta_log = new JTextArea(10,60);
	JScrollPane jsp_log = new JScrollPane(jta_log
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//통신에 대한 처리
	@Override
	public void run() {//통신에 대한 처리 - 지연, 끊김, 노이즈, 대기
		//서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기 
		globalList = new Vector<>();
		boolean isStop = false;
		try {
			server = new ServerSocket(3002);
			jta_log.append("Server Ready.........\n");
			while(!isStop) {
				socket = server.accept();
				jta_log.append("client info:"+socket+"\n");				
				ChatServerThread cst = new ChatServerThread(this);
				cst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initDisplay() {
		jta_log.setLineWrap(true);
		jf.setBackground(Color.green);
		jf.add("Center", jsp_log);
		jf.setTitle("서버측 로그출력 화면");
		jf.setSize(800, 600);
		jf.setVisible(true);
	}
	
	//메인 메소드도 스레드 (entry point) - 시작점 (exe파일을 만든다)- 경합이 일어남
	public static void main(String[] args) {
		ChatServer cs = new ChatServer();
		//두 메소드가 호출되었을 때 지연 발생하는 메소드는 start()이다.
		//같은 메소드라도 처리되는 시간이 다르다.
		cs.initDisplay();
		cs.start();
	}
}
