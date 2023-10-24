package CodingTest;


public class Test6 {

	public static int[] solution(int num, int total) {
        int centerValue = 0;
        int centerLoc = 0;
        int firstNum = 0;
        //센터 값
        centerValue = total/num;
        //sum을 2로 나누었을때 나누어 떨어진다면 센터위치 = 나눈몫
        //나누어 떨어지지 않는다면 센터위치 = 나눈몫 -1  
        if(num%2==0){
           centerLoc = (num/2)-1;
        }else{
           centerLoc = num/2;
        }
        firstNum = centerValue-centerLoc;
        
        int[] answer = new int[num]; 
        for(int i = 0; i < num; i++){
           answer[i] = firstNum + i;             
        }
        
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(solution(3, 12));
	}
}
