package com.step5;

import java.util.ArrayList;

public class List1 {

	public static void main(String[] args) {
		String s1 = null;
		String s2 = null;
		String s3 = null;
		
		ArrayList fruits = new ArrayList();
		fruits.add("사과");
		s1 = (String)fruits.get(0);
		fruits.add(1,"딸기");
		s2 = (String)fruits.get(1);
		fruits.add(1, "바나나");
		s3 = (String)fruits.get(2);
		
		for(int i = 0; i<fruits.size(); i++) {
			System.out.println(fruits.get(i));
		}
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
