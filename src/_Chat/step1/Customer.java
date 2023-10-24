package _Chat.step1;

import javax.swing.JFrame;

public class Customer extends JFrame implements Runnable{

	public static void main(String[] args) {
		Customer ct = new Customer();
		Thread th = new Thread(ct);
		th.start();	// run 을 직접 호출하는 것이 아니라 start호출 하면 시스템이 적당한 시기에 대신 호출함.-콜백 메서드
	}

	@Override
	public void run() {
		System.out.println("run 호출 성공");
	}
}
