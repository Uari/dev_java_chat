package com_step3;

public class EmpSimulation2 {
	
	void setEmp(Emp emp) {
		emp.empno = 7566;
		emp.ename = "Smith";
		emp.jpb = "영업";
		System.out.println("=====before========");
		System.out.println(emp.empno + "," + emp.ename + "," + emp.jpb);
	}

	public static void main(String[] args) {
		EmpSimulation2 es2 = new EmpSimulation2();
		Emp emp = new Emp();
		es2.setEmp(emp);
		System.out.println("=====after========");
		System.out.println(emp.empno + "," + emp.ename + "," + emp.jpb);
	}
}
