package com.ex_interface;

public class DuckSoundMain {

	void methodA(Squeak squeak) {
		System.out.println("methodA"+squeak);
	}
	void methodB(DuckSound ds) {
		System.out.println("methodB"+ds);
	}
	
	public static void main(String[] args) {
		//선언부와 생성부의 타입이 다르다. - 권장사항 - 범위가 더 넓은 걸
		//유자보수시에 코드의 수정을 최소화 하는 역할
		DuckSoundMain dm = new DuckSoundMain();
		DuckSound ds = new Squeak();
		Quack dq = new Quack();
		//dm.methodA(dq);
		dm.methodB(dq); //인터페이스의 다형성 
		WoodDuck dw = new WoodDuck();
		Squeak ss = new Squeak();
		ds.quack();
	}
}
