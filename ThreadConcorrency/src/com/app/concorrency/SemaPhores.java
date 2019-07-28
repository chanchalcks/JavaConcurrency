package com.app.concorrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
	INSTANCE;

	Semaphore sm = new Semaphore(5);

	public void display() {
		try
		{
		sm.acquire();
		Thread.sleep(1000);
		System.out.println("downloading data..........");
		sm.release();
		}
		catch(Exception e)
		{
			
		}
	}

}

public class SemaPhores {

	public static void main(String[] args) {

		Executor ex = Executors.newCachedThreadPool();

		ex.execute(new Runnable() {

			@Override
			public void run() {
				while(true)
				Downloader.INSTANCE.display();
			}
		});

	}

}
