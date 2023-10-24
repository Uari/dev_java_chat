package com_step2;

public class Pride {
	private int speed;
	private String carColor;
	
	//getter 메소드는 전역변수에 담긴 값을 꺼낼때 사용
	public String getCarColor() {
		return carColor;
	}
	//setter메소드는 전역변수가 private이라서 직접 접근이 불가하니까
	//메소드의 파라미터 자리를 활용하여 결정된 값을 전변에 초기화 
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public int getWheelNum() {
		return wheelNum;
	}

	public void setWheelNum(int wheelNum) {
		this.wheelNum = wheelNum;
	}

	private int wheelNum;
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
}
