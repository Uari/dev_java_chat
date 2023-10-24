package com_step3;

public class Service {
	
	public int total(StudentInfo si) {
		int sum = 0;
		sum = si.getCss()+si.getHtml()+si.getJava();
		return sum;
	}
	public double avg(int sum) {
		double av;
		av = sum/3.0;
		return av;
	}

}
