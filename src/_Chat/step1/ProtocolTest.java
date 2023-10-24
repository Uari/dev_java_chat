package _Chat.step1;

import java.util.StringTokenizer;

public class ProtocolTest {

	public static void main(String[] args) {
		String msg = "200|kiwi|tomato|오늘 스터디?";
		StringTokenizer st = new StringTokenizer(msg, "|");//token
		//String protocol = st.nextToken();	//200
		//String from = st.nextToken();		//kiwi
		//String to = st.nextToken(); 		//tomato
		//String msg1 = st.nextToken();		//오늘 스터디?
		
//		while(st.countTokens()>0) {
//			System.out.println(st.nextToken());
//		}
		
//		while(st.hasMoreElements()) {
//			System.out.println(st.nextToken());
//		}
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
