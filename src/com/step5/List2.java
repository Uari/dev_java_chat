package com.step5;

import java.util.ArrayList;

public class List2 {

	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<String>();
		fruits.add("사과");
		fruits.add(1,"딸기");
		fruits.add(1, "바나나");
		String r1 = fruits.remove(1);
		System.out.println(fruits);
		System.out.println(r1);
	}
}
