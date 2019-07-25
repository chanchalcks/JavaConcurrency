package com.app.concorrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {
	private Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void consumer() throws InterruptedException {

		lock.lock();
		System.out.println("this is consumer");
		
		condition.signal();
		lock.unlock();

	}

	public void producer() throws InterruptedException {

		lock.lock();
		System.out.println("this is producer");
		condition.await();
		System.out.println("producer again");
		lock.unlock();
		
	}

}

public class ProducerConsumerWithLock {

	public static void main(String[] args) {
		Worker worker = new Worker();

		Runnable r1 = () -> {
			try {
				worker.producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable r2 = () -> {
			try {
				worker.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};

		new Thread(r1).start();
		new Thread(r2).start();

	}

}
