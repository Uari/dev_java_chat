package com_step2;

public class String1 {

	public static void main(String[] args) {
		
		String s1 = new String("키위");
		System.out.println(s1);
		
		//같은 이름의 변수 이더라도 new를 사용해서 인스턴스화를 한번더 하면 다른 주소번지를 가리킨다
		s1 = new String("키위");
		System.out.println(s1);
	}
}
