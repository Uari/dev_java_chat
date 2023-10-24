package com.step5;

import java.util.ArrayList;
import java.util.List;

public class List4 {
	List<DeptVO> li = new ArrayList<>(); //확장성, 유지보수 할때 코드 수정의 양을 줄여준다.
	public static void main(String[] args) {
		List4 l4 = new List4();
		DeptVO dept = new DeptVO();
		dept.setDeptno(10);
		dept.setDname("영업부");
		dept.setLoc("부산");
		l4.li.add(dept);
		dept = new DeptVO();
		dept.setDeptno(20);
		dept.setDname("개발부");
		dept.setLoc("서울");
		l4.li.add(dept);

		for(int i = 0; i<l4.li.size(); i++) {
			DeptVO d = l4.li.get(i);
			System.out.println(d.getDeptno()+","+d.getDname()+","+d.getLoc());
		}
	}
}
