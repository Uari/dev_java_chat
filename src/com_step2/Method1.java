package com_step2;

import java.util.Scanner;

public class Method1 {

	//메소드 리턴타입에 void가 아닌 원시형 또는 참조형이 오면 반드시 마지막에(맨끝에)return 예약어를 쓴다
	
	static Scanner sc = new Scanner(System.in);
	
	public String login(String id, String pw) {
		String pid = id;
		String ppw = pw;
		if(pid.equals("bio") && ppw.equals("1234")) {
			return "로그인 성공";
		}else {
			return "id와 pw가 맞지 않음";
		}
	}
	public int methodA() {
		return 0;
	}
	public double methodB() {
		return 0.0;
	}
	public boolean methodC() {
		return true;
	}
	public void methidD() {
		//void는 return 값이 없음
	}
	public static void main(String[] args) {
		System.out.println("아이디 : ");
		String ss = sc.nextLine();
		System.out.println("비밀번호 : ");
		String ss2 = sc.nextLine();
		
		Method1 m = new Method1();
		String name = m.login(ss, ss2);
		System.out.println(name);
	}
}
/*
	메소드 선언하기
	 1. 리턴타입을 결정해 주세요
	 2. 파라미터가 필요한가? 몇개?
	 3. 나만 사용할 건지? 공유할 건지 결정 - private, public
	 public > protected > friendly > private
	
	 protected - 서로 다른 패키지라 하더라도 서로 상속관계에 있으면 접근할 수 있다.
	 접근제한자가 아무것도 없으면 friendly 상태라 함 - 접근할 수 없다
	
	메소드를 선언하는 문장
	 (접근제한자) 리턴타입(void, 원시형타입, 참조형 타입)메소드이름(빈상태, 한개, 두개이상)
*/