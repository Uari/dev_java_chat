package com_step2;

public class Method2 {

	public String login(String id, String pw) {
		
		String name = "나신입";
		int a = 100;
		
		
		
		return name;
	}
	public void methidD() {
		//void는 return 값이 없음
	}
	public static void main(String[] args) {
		
		Method2 m = new Method2();
		//m.login("kk", "11");
		//println 메소드 호출할 때 파라미터 자리에서 리턴타입이 있다면 호출할 수 있음
		System.out.println(m.login("kk", "11"));
		
	}
}
