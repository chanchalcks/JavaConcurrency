package com.app.concorrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

class Workers {
	Semaphore add = new Semaphore(1);
	Semaphore reader = new Semaphore(1);
	
	BlockingQueue<Integer> queue=new LinkedBlockingDeque<>(10);

	public void producer(int data) {
		try {
			add.acquire();
			Thread.sleep(1000);
			queue.put(data);
			add.release();
		} catch (Exception e) {

		}
	}

	public void consumer() {
		try {
			reader.acquire();
			Thread.sleep(1000);
			System.out.println(queue.take());
			reader.release();
		} catch (Exception e) {

		}
	}

}

public class ProduerConsumerSemaPhores {

	public static void main(String[] args) {
		Workers worker = new Workers();

		Executor ex = Executors.newFixedThreadPool(10);
		ex.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					worker.producer(10);
					worker.consumer();
				}

			}
		});

	}

}
