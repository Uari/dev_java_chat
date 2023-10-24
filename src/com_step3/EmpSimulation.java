package com_step3;

public class EmpSimulation {
	
	public void empPrint(Emp emp) {
		System.out.println(emp.empno + "," + emp.ename + "," + emp.jpb);
	}

	public static void main(String[] args) {
		EmpSimulation es = new EmpSimulation();
		Emp emp = new Emp();
		emp.empno = 7566;
		emp.ename = "나신입";
		emp.jpb = "마케팅";
		es.empPrint(emp);
		//새로운 신입사원이 한명 더 입사 하였다
		emp = new Emp();
		emp.empno = 7499;
		emp.ename = "나초보";
		emp.jpb = "매니자";
		es.empPrint(emp);
	}
}
