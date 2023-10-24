package com_step2;

/*
class Pride {
	private int speed;
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
}
*/

public class PrideSimulation {

	public static void main(String[] args) {
		Pride myCar = new Pride();	//30km
		Pride yourCar = new Pride();//50km
		Pride himCar = new Pride();	//100km
		
		myCar.setSpeed(30);
		yourCar.setSpeed(50);
		himCar.setSpeed(100);
		
		int mySpeed = myCar.getSpeed();
		int yourSpeed = yourCar.getSpeed();
		int himSpeed = himCar.getSpeed();
		
		System.out.println("mySpeed : " + mySpeed);
		System.out.println("yourSpeed : " + yourSpeed);
		System.out.println("himSpeed : " + himSpeed);
	}
}
