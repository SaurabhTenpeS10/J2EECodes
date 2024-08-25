package com.multithreading.deadlock;




public class ThreadMain {
	public static void main(String[] args) {
		MyResource myResource = new MyResource();
	MyThread1 myThread1 = new MyThread1(myResource);
	MyThread2 myThread2 = new MyThread2(myResource);
	
	myThread1.start();
	myThread2.start();
	
	}
}
