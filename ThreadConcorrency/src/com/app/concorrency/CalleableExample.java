package com.app.concorrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class A implements Callable<Integer> {
	int value = 0;

	public A(int value) {
		this.value = value;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		return value;
	}

}

public class CalleableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(10);

		for (int i = 0; true; i++) {
			Future<Integer> a = service.submit(new A(i));
			System.out.println(a.get());
		}

	}

}
