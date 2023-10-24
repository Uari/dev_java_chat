package _Chat.step1;

import java.util.List;
import java.util.Vector;

public class List1 {

	public static void main(String[] args) {
		List<String> list = new Vector<>();
		list.add(0,"사과");
		list.add(1,"키위");
		list.add(2,"토마토");
		String apple = list.get(0);
		System.out.println(apple);
		System.out.println(list);
	}
}
