package com.multithreading.deadlock;

public class MyThread1 extends Thread {
	private MyResource myResource;

	public MyThread1() {
		super();
	}

	public MyThread1(MyResource myResource) {
		super();
		this.myResource = myResource;
	}
	@Override
	public void run() {
		synchronized (myResource.r1) {
			System.out.println("Lock Apply on Resource 1 by Thread 1");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (myResource.r2) {
			System.out.println("Lock Appllied on R2 by Mythread2");
		}
	}
}
