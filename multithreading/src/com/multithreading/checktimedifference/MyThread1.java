package com.multithreading.checktimedifference;

public class MyThread1 extends Thread{

	@Override
	public void run() {
		for(int i=1; i<=5;i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
