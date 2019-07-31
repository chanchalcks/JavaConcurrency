package com.app.concorrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Runnable run=()->
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		};

		ExecutorService service =Executors.newFixedThreadPool(10);
		
		  while(true)
		     service.execute(run);
		
	}

}
