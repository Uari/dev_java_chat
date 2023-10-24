package com.step5;

import java.util.ArrayList;

public class List3 {
	void getFruitList(ArrayList<String> fruits) {
		for(int i=0; i<fruits.size(); i++) {
			System.out.println(fruits.get(i));
		}
	}
	ArrayList<String> methodA(){
		
		ArrayList<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add(1,"딸기");
		fruits.add(1, "바나나");
		return fruits;
	}
	public static void main(String[] args) {
		List3 l3 = new List3();
		l3.getFruitList(l3.methodA());
		ArrayList<String> fruits = l3.methodA();
		System.out.println();
	}
}
