package CodingTest;

public class Test5 {

	public static int solution(String[] babbling) {
		int answer = 0;

		for (int i = 0; i < babbling.length; i++) {
			babbling[i] = babbling[i].replace("aya", "");
			babbling[i] = babbling[i].replace("woo", "");
			babbling[i] = babbling[i].replace("ye", "");
			babbling[i] = babbling[i].replace("ma", "");
			//babbling[i] = babbling[i].replace("1", "");
			if (babbling[i].isEmpty()) {
				answer = answer + 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] babbling = { "ayaye", "uuuma", "ye", "yemawoo", "ayaa" };
		System.out.println(solution(babbling));
	}
}
