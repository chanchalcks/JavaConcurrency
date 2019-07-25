package com.app.concorrency;

class Runner1 implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++)
			System.out.println("runner1=" + i);

	}
}

class Runner2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("runner2=" + i);

	}
}

public class RunnableExample {
	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runner1());
		t1.start();
		Thread t2 = new Thread(new Runner2());
		t2.start();
		
		t1.join();
		System.out.println("Task finished");
		
		// using join so t1 thread can finish the task first then thread and main thread can execute concorrently
		
	}

}
