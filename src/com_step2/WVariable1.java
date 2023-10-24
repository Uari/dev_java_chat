package com_step2;

class Dog{
	//클래스 선언 바로 뒤에 붙여서 선언
	int leg = 4;
	
	public int running() {
		int leg = 6;
		return leg;
	}
}

public class WVariable1 {

	public static void main(String[] args) {
		Dog d = new Dog();
		System.out.println(d.running());
	}
}
