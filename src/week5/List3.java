package week5;
/*
 * List의 제네릭 타입으로 VO를 선택할 것인가? 아니면 Map을 선택하는 것이 맞는걸까?
 * 기준?
 * BookVO
 * 
 * Map<String, Object>
 */

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List3 {
	
	void methodA(List<BookVO> bookList) {
		BookVO rbVO = bookList.get(0);
		System.out.println((Integer)rbVO.getB_price() instanceof Integer);
	}
	
	void methodB(List<Map<String, Object>> bookList) {
		Map<String, Object> rmap = bookList.get(0);
		System.out.println(rmap.get("b_price") instanceof Integer);
		System.out.println(rmap.get("b_price") instanceof Object);
		System.out.println(rmap.get("b_price") instanceof String);
	//	System.out.println(rmap.get("b_price")*5);
	}
	public static void main(String[] args) {
		List3 list3 = new List3();
		List<BookVO> bookList = new ArrayList<>();
		BookVO bVO = new BookVO();
		
		bVO.setB_no(1);
		bVO.setB_title("자바의 정석");
		bVO.setB_author("남궁성");
		bVO.setB_price(30000);
		bookList.add(bVO);
		
		List<Map<String, Object>> bookMap = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		
		map.put("b_no", 1);
		map.put("b_title", "자바의 정석");
		map.put("b_author", "남궁성");
		map.put("b_price", 30000);
		
		bookMap.add(map);
		
		list3.methodA(bookList);
		list3.methodB(bookMap);
	}
}