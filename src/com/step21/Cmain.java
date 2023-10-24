package com.step21;

class C {
	
	int tot;
	int avg;
}
class C1 {
	C c = new C();
	
	// 또 다른 방법이 있을까? 전변을 살려서 처리할 수 없을까?(원본을 살려서)
	
	int hap(int n1, int n2, int n3, C c) { // 파라미터 옆에 참조형 타입으로 할까.
		// 2. Call by reference(참조에 의한 호출: C c = null)
		c.tot = n1 + n2 + n3;
		return c.tot;
	}
	
	void average() {
		
	}
}
public class Cmain {
	public static void main(String[] args) {
		int n1 = 70;
		int n2 = 80;
		int n3 = 90;
		
		C c = new C();
		C1 c1 = new C1();
		// int hap(int n1, int n2, int n3) 여기에 인스턴스화를 하지 말고(하지 않고서도) 가능하다
		// 왜? 참조형을 넘길 수 있으니까
		// hap 메소드 안에서도 C클래스에 대한 인스턴스화가 필요하였고
		// main메소드 안에서도 전변 tot를 출력하기 위해서 필요하였다
		// 그런데 메소드 호출이 먼저니까 (c.tot를 출력하는 것보다) C에 대한 인스턴스화를 진행함
		// 그 주소번지를 hap 메소드의 파라미터로 넘기면, 원본을 넘기는 것이니까 c.tot가 유지된다(값이 유지된다)
		int tot = c1.hap(n1, n2, n3, c); // 1. 원본(c)를 넘겨주고
		
		System.out.println(c.tot);
	}
}