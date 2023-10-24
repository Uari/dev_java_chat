package com.ex_interface;

public class Squeak implements DuckSound {

	@Override
	public void quack() {
		System.out.println("빽!");
	}
}