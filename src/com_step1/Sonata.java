package com_step1;

public class Sonata {

	//자동차를 생각나게하는 고유명사 - speed, WheelNum,
	
	//선언부에 선언하는 변수는 전역변수이다(global variable)

	int speed = 10;// 호출하면 값이 나온다 - 원시타입(primative data tyoe)
	int wheelNum = 4;
	String carColor = "Black"; // 대문자로 시작하는 건 클래스이다(referece data type)
	
	public static void main(String[] args) {
		
		//myCar - 인스턴스화에 사용된 변수를 인스턴스변수라고 한다.
		//인스턴스변수를 통해서 호출할 수 있는건 전역변수이다. 지역변수는 불가
		Sonata myCar = null;
		myCar = new Sonata();
		Sonata herCar = new Sonata();
		herCar.speed = 50;
		System.out.println(myCar.speed);
		//원시형 타입에는 한번에 하나만 담을 수 있다.
		//동시에 두개의 값을 가질 수 없다.
		System.out.println(herCar.speed);
	}
}
