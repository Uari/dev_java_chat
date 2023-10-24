package com_step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Method4 {
	//3사람의 점수를 입력 받아서 총점과 평균을 구하시오

	Scanner sc = new Scanner(System.in);
	
	//점수를 입력 받는 메소드
	private List<Integer> insertScore() {
		List<Integer> listA = new ArrayList<Integer>();
		//세사람의 점수를 입력 받는다
		
		int i = 0;
		int cnt = 3; //사람 수 카운터
		
		for(i=0; i<cnt; i++) {
			System.out.println((i+1) + "번 사람의 점수 : ");
			int nScore = sc.nextInt();
			listA.add(nScore);
		}
		
		//System.out.println("A의 점수 : ");
		//int aScore = sc.nextInt();
		//System.out.println("B의 점수 : ");
		//int bScore = sc.nextInt();
		//System.out.println("C의 점수 : ");
		//int cScore = sc.nextInt();
		//listA.add(aScore);
		//listA.add(bScore);
		//listA.add(cScore);
		return listA;
	}
	
	//세사람의 총합
	private int total(List<Integer> listScore) {
		int i;
		int sum = 0;
		for(i=0; i<listScore.size(); i++) {
			sum = sum + listScore.get(i);
		}
		System.out.println("총합 : " + sum);
		return sum;
	}
	
	//세사람의 평균
	private void aberage(int s, double d) {
		double ab = s/d;
		System.out.println("평균 : " + ab);
	}
	
	public static void main(String[] args) {
		System.out.println("세사람들의 점수 총합과 평균 구하기");
		
		int sum = 0;
		Method4 m4 = new Method4();
		List<Integer> listScore = new ArrayList<Integer>();
		//세사람의 점수를 입력 받는다
		listScore = m4.insertScore();
		//세사람의 점수 총점
		sum = m4.total(listScore);
		//세사람의 점수 평균
		m4.aberage(sum, listScore.size());
	}
}
