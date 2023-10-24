package com_step2;

public class Method3 {

	public String login(String id, String pw) {
		String name = "나신입";
		return name;
	}
	public void methidD(String n) {
		System.out.println("methodD호출성공");
		System.out.println("나의 이름은 : " + n);
	}
	public static void main(String[] args) {
		
		Method3 m = new Method3();
		//methodD()는 리턴타입이 void라서 대입연산자를 통해서 받을 수가 없다.
		//int i = m.methodD();
		//m.methidD();
		String name = m.login("apple", "123");
		m.methidD(name);
		//main안에서 선언한 지변 name의 값을 굳이 methodD에서 쓰고 싶음 ?
	}
}
