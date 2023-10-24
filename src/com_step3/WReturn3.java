package com_step3;

class Sonata{
	int speed = 0; //현재 소나타는 주차되어 있다.
	String carColor = "빨강";
}

public class WReturn3 {
	//메소드에 리턴타입으로 참조형 변수를 사용할 수 있다.
	Sonata getCar() {
		return new Sonata();
	}
	public static void main(String[] args) {
		Sonata myCar = new Sonata();
		System.out.println(myCar.carColor);
		WReturn3 w3 = new WReturn3();
		Sonata himCar = w3.getCar();
	}
}
