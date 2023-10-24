package com_step3;

public class WReturn2 {
	int i;
	void methodA() {
		int i = 2;
	}
	//두수를 받아서 합하는 기능 
	int methodB(int a, int b) {
		int sum = a + b;
		return sum;
	}
	public static void main(String[] args) {
		WReturn2 w = new WReturn2();
		boolean b = true;//false;
		int i = 0;
		int sum = 0;
		
		for(i=0; i<101; i++) {
			sum += i;// = sum = sum + 1;
		}
		
		
	}
}
