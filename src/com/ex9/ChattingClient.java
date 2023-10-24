package com.ex9;

import java.util.Calendar;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChattingClient {
	private String getTimeStr() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);

		return (hour < 10 ? "0" + hour : "" + hour) + ":" + (min < 10 ? "0" + min : "" + min) + ":"
				+ (sec < 10 ? "0" + sec : "" + sec);
	}

	public class ClientTest {
		int socketPort = 5050;
		int bufferSize = 1024;

		public void fncClient() {
			Socket socket;

			try {
				// Socket 생성
				socket = new Socket();

				// 연결 시도
				socket.connect(new InetSocketAddress("localhost", socketPort));

				// 데이터 보내는 부분
				OutputStream output = socket.getOutputStream();

				String msgStr = "test message";
				byte[] bytes = msgStr.getBytes();

				// 보내기
				output.write(bytes);
				output.flush();

				output.close();
			} catch (Exception e) {
				// Exception 처리
			}
		}

	}

}
