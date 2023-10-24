package CodingTest;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

	public static int solution(String[] babbling) {
		int answer = 0;
		int i, j, x, z = 0;
		List<String> strList = new ArrayList<String>();

		String[] babyList = { "aya", "ye", "woo", "ma" };
		for (i = 0; i < babyList.length; i++) {
			strList.add(babyList[i]);
			for (j = 0; j < babyList.length; j++) {
				strList.add(babyList[i] + babyList[j]);
				for (x = 0; x < babyList.length; x++) {
					strList.add(babyList[i] + babyList[j] + babyList[x]);
					for (z = 0; z < babyList.length; z++) {
						strList.add(babyList[i] + babyList[j] + babyList[x] + babyList[z]);
					}
				}
			}
		}

		for (i = 0; i < strList.size(); i++) {
			for (j = 0; j < babbling.length; j++) {
				if (strList.get(i).equals(babbling[j])) {
					answer++;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] babbling = { "ayaye", "uuuma", "ye", "yemawoo", "ayaa" };
		System.out.println(solution(babbling));
	}
}
