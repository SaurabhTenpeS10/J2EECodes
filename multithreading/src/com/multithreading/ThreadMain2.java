package com.multithreading;

public class ThreadMain2  {
	public static void main(String[] args) {
		
		MyThread3 myThread3 = new MyThread3();
		myThread3.start();
		
		MyThread4 myThread4 = new MyThread4();
		myThread4.start();
		
		
	}
}
