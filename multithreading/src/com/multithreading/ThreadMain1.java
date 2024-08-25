package com.multithreading;

public class ThreadMain1 {
	
	public static void main(String[] args) {
		
		MyThread1 myThread1 = new MyThread1();
		Thread thread1 = new Thread(myThread1);
		thread1.start();
		
		MyThread2 myThread2 = new MyThread2();
		Thread thread2 = new Thread(myThread2);
		thread2.start();
		
	}

}
