package com_step3;

public class DeptSimulation {

	public static void main(String[] args) {
		Dept dept = new Dept();
		dept.deptno = 10;
		dept.dname = "개발부";
		dept.loc = "서울";
		System.out.println(dept.deptno + "," + dept.dname + "," + dept.loc + ",");
		dept = new Dept();
		dept.deptno = 20;
		dept.dname = "운영부";
		dept.loc = "대전";
		System.out.println(dept.deptno + "," + dept.dname + "," + dept.loc + ",");
		dept = new Dept();
		dept.deptno = 30;
		dept.dname = "기획부";
		dept.loc = "제주";
		System.out.println(dept.deptno + "," + dept.dname + "," + dept.loc + ",");
	}
}
