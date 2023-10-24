package com.step5;

import java.util.HashMap;
import java.util.Map;

public class MapTest1 {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("deptno", 10);
		map.put("dname", "영업부");
		map.put("loc", "부산");
		
		System.out.println(map.get("deptno"));
		System.out.println(map.containsKey("deptno"));
		System.out.println(map.containsKey("Deptno"));
		if(map.containsKey(10)) {
			System.out.println("키가 있음");
		}else {
			System.out.println("키가 없음");
		}
	}
}
