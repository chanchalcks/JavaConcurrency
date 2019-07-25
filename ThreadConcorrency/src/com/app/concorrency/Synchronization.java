package com.app.concorrency;

public class Synchronization {

	static int value = 0;

	public static void increament() {
		System.out.println(Thread.currentThread().getName());
		++value;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Runnable r1 = () -> {
			for (int i = 0; i < 10; i++) {
				increament();
			}
		};

		Runnable r2 = () -> {

			for (int i = 0; i < 10; i++) {
				increament();
			}
		};

		Thread t1 = new Thread(r1,"Thread_One");
		Thread t2 = new Thread(r2,"Thread_Two");
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println("total count value="+value);

	}

}
