package com.step6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 엄무요청애 대한 결과가 조인이 불가피할 때 하나의 클래스로 제네릭을 사용할 수 없다.
 * Map인터페이스를 사용하는 것이 효과적임 - 키와 값으로 관리함
 * 키를 컬럼명으로 통일하면 일관성있는 변수명으로 접근이 가능함 - 속도도 빠름
 */
import javax.swing.JButton;

import com.google.gson.Gson;
class Emp1{
	private int empno = 0;
	private String ename = null;
}
class Dept1{
	private String dname = null;
}

public class AddList {

	public static void main(String[] args) {
		JButton jbtnSelect = new JButton();
		//선언부와 생성부의 이름이 다르면 다형성을 누릴수 있다.
		//다형성에 대한 전제조건이다.
		//인터페이스, 추상 클래스 변수명 = new 구현체 클래스();
		//재사용성을 높인다. 이식성을 좋게함. 유연하다
		List<JButton> li = new ArrayList<>();
		//List 인터페이스의 구현체 클래스가 ArrayLsit이다.
		//인터페이스는 단독으로 인스턴스화를 할 수 없다.
		
		
		List<Map<String, Object>> list = new ArrayList<>(); //[]형식을 가짐
		Map<String, Object> map = new HashMap<>();
		map.put("empno", 7782);
		map.put("ename", "CLARK");
		map.put("dname", "ACCOUNTING");
		list.add(map);
		System.out.println(list);
		Gson g = new Gson();
		String temp = g.toJson(list);
		System.out.println(temp);
	}
}
