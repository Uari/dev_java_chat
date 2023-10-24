package com.step5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest3 {

	public static void main(String[] args) {
		List<Map<String, Object>> deptList = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("DEPTNO", 10);
		map.put("DNAME", "영업부");
		map.put("LOC", "부산");
		deptList.add(map);
		
		Set<String> set = map.keySet();
		Object keys[] = set.toArray();
		for(int i= 0; i<keys.length; i++) {
			System.out.println(keys[i]+" === >"+map.get(keys[i]));
		}
		System.out.println(deptList.get(0).get("DEPTNO"));
		System.out.println(deptList.get(0).get("dname"));
		System.out.println(deptList.get(0).get("LOC"));
	}
}
