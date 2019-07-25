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
	public static void main(String[] args) {

		new Thread(new Runner1()).start();
		new Thread(new Runner2()).start();
	}

}
