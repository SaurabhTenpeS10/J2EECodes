package com.multithreading.checktimedifference;

public class MyThread2 extends Thread {
	@Override
	public void run() {
		for(int i=6; i<=10;i++)
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
