package network5;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class TalkClientThread extends Thread {
	TalkClient tc = null;

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
				case 100: {
					String nickname = st.nextToken();
					tc.jta_display.append(nickname+"님이 접속하셨습니다. \n");
					Vector<String> v = new Vector<>();
					v.add(nickname);
					tc.dtm.addRow(v);
				}break;
				case 200:{
					
				}
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
