package com.app.concorrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

	private final BlockingQueue<Runnable> queue;
	private final Thread[] workerThread;

	public CustomThreadPool(int numThread) {

		queue = new LinkedBlockingQueue<>();
		workerThread = new Thread[numThread];

		for (Thread t : workerThread) {
			t = new Worker();
			t.start();
		}

	}

	public void addTask(Runnable r) {
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class Worker extends Thread {

		@Override
		public void run() {
			try {
				while (true)
					queue.take().run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		CustomThreadPool pool = new CustomThreadPool(3);
		while (true) {
			pool.addTask(() -> System.out.println(Thread.currentThread().getName()+":"+Math.random()));
		}

	}

}
