package com.multithreading.checktimedifference;

public class ThreadMain2 {

	public static void main(String[] args) {
		
		MyThread1 myThread1 = new MyThread1();
		MyThread2 myThread2 = new MyThread2();
		
		long start = System.currentTimeMillis();
		myThread1.start();
		myThread2.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}

}
