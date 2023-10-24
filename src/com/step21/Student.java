package com.step21;

public class Student {
	int html 	= 0;
	int css 	= 0;
	int java 	= 0;
	public static void main(String[] args) {
		//for(1-초기화;2-조건식;3-증감연산자)
		//for문에서 조건식이 true이면 for문안에 실행문이 차례대로 실행됨
		Student s = new Student();
		s.html = 70;
		s.css = 80;
		s.java = 90;
		System.out.println(s);
		s = new Student();
		s.html = 60;
		s.css = 70;
		s.java = 80;		
		System.out.println(s);
		s = new Student();
		s.html = 50;
		s.css = 60;
		s.java = 70;		
		System.out.println(s);
	}
}