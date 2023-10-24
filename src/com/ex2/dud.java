package com.ex2;

import java.util.Random;

public class dud {

	public static void main(String[] args) {
		Random r = new Random();
		int rNum = r.nextInt(1000);
		String rmDud = String.valueOf(rNum);

		for (int i = 0; i < rmDud.length(); i++) {
			for (int j = 0; j < rmDud.length(); j++) {
				if (i != j) {
					if(rNum < 100) {
						rNum = r.nextInt(1000);
						rmDud = String.valueOf(rNum);
						i = 0;
						break;
					}else if (rmDud.charAt(i) == rmDud.charAt(j)) {
						rNum = r.nextInt(1000);
						rmDud = String.valueOf(rNum);
						i = 0;
						break;
					}
				}
			}
		}
	}
}
