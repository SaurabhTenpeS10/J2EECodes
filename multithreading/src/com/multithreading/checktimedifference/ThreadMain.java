package com.multithreading.checktimedifference;

public class ThreadMain {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
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
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
		
	}
}
