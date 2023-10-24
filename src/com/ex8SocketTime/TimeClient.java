package com.ex8SocketTime;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//socket(싱글스레드)
//ip : 172.16.2.27
//port : 5050
//new Socket("172.16.2.27", 5050)
public class TimeClient extends Thread {

	TimeView tv;
	public TimeClient(TimeView tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		System.out.println("run 호출");
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		String timeStr = null;
		try {
			socket = new Socket("172.16.2.27", 5050);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			while (true) {
				timeStr = ois.readObject().toString();
				//System.out.println(timeStr);
				tv.jlt.setText(timeStr);
				tv.jf.setTitle(timeStr);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) { 
					// TODO: handle exception
				}
			} //////// end of while ////////////
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ois.close();
				oos.close();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}/////////////// end of run /////////////////
}
