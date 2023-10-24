package CodingTest;

class Solution {
	public int solution(String A, String B) {
        int answer = 0;
        for(int i = 0; i<A.length(); i++) {
        	if(A.equals(B)) {
            	break;
            }else {
            	
            	answer++;
            }
        }
        return answer;
    }
}

public class Test8 {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution("hello", "ohell");
	}
}
