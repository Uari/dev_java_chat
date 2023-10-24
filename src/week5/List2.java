package week5;

import java.util.List;
import java.util.Map;

public class List2 {
	
	void methodA(List<BookVO> bookList) {
		BookVO bVO = new BookVO();
		bVO.setB_title("수학의 정석");
		System.out.println(bVO.getB_title());
		bVO = new BookVO();
		System.out.println(bVO.getB_title());
	}
	
	void methodB(List<Map<String, Object>> bookList) {
		
	}
	public static void main(String[] args) {
		List2 list2 = new List2();
		list2.methodA(null);
	}
}