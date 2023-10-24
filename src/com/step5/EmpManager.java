package com.step5;

import java.util.ArrayList;

public class EmpManager {
	
	ArrayList<EmpVO> empList = new ArrayList<>();
	void getEmpList() {
		System.out.println(empList.size());
		EmpVO emp = new EmpVO();
		empList.add(0, emp);
		emp = new EmpVO();
		empList.add(1, emp);
		System.out.println(empList.size());
		for(int i = 0; i<empList.size(); i++) {
			EmpVO remp = empList.get(i);
			System.out.println(remp.getEmpno()+","+remp.getEname()+","+remp.getHiredate());
		}
	}
	public static void main(String[] args) {
		EmpManager em = new EmpManager();
		em.getEmpList();
	}
}
