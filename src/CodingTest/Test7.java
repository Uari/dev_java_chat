package CodingTest;


public class Test7 {
	public static int solution(int[] common) {
        int answer = 0;
        //1. 등차수열이냐 등비수열이냐 구분
        //2. 등차수열이면 마지막 수에 +공차수
        //3. 등비수열이면 마지막 수에 *등비수
        if((common[1] - common[0]) == (common[2] - common[1])){
            //등차수열
            answer = common[common.length-1] + (common[1] - common[0]);
        }else{
            //등비수열
            answer = common[common.length-1] * (common[1]/common[0]);
        }
        return answer;
    }

	public static void main(String[] args) {
		int[] common = {1,2,3};
		solution(common);
	}
}
