package com.step21;
class D {
	// 하나로 합치니까 C에 대한 인스턴스화가 필요없게 되었다.
	// 이러한 이유로 (static이 아닌데) 원본 하나로 관리되고 있다는 걸 봐야한다
	// 그래서 0이 출력되는 게 아니고 240이 출력된다
	int tot;
	int avg;
	
	void hap(int n1, int n2, int n3) {
		// Cmain에서는 클래스를 3개로 나눴는데 Dmain에서는 2개로 통합했다
		// c.tot -> c가 필요없는 건 전역변수가 내 안에 있기 때문이다
		// 이것만으로 복사본이 아니라 원본을 유지(웹:쿠키와 세션)할 수 있다
		tot = n1+n2+n3;
}
	void average() {
		
	}
}
public class Dmain {
	public static void main(String[] args) {
		int n1 = 70;
		int n2 = 80;
		int n3 = 90;
		
		D c = new D();
		c.hap(n1, n2, n3); // 합을 구하는 메소드 경유
		
		System.out.println(c.tot); // 240이 출력
	}
}








