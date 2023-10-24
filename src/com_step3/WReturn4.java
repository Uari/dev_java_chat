package com_step3;
	
class Dept1{
	int deptno = 30;
	String dname = "운영부";
	String loc = "제주도";
}
class Dept{
	int deptno = 10;
	String dname = "개발부";
	String loc = "부산";
}
public class WReturn4 {
	int getDeptno() {
		int deptno = 10;
		return deptno;
	}
	String getLoc() {
		String loc = "부산";
		return loc;
	}
	//void getDept(int deptno, String dname, String loc) {
		
	//}
	//void getDept(Dept dept) {
		
	//}
	int getDept(int deptno, String dname, String loc) {
		return deptno;
	}
	Dept getDept() {
		Dept dept = null;
		return dept;
	}
	
	public static void main(String[] args) {
		
	}
}
