package com.multithreading.deadlock;

public class MyThread2 extends Thread{
	private MyResource myResource;
	
	public MyThread2() {
		super();
	}
	

	public MyThread2(MyResource myResource) {
		super();
		this.myResource = myResource;
	}


	@Override
	public void run() {
		synchronized (myResource.r2) {
			System.out.println("Lock is apply on Resource2 by MyThread2");
		}
		super.run();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		synchronized (myResource.r1) {
			System.out.println("Lock is Apply on Resource1 by MyThread2");
		}
	}
}
