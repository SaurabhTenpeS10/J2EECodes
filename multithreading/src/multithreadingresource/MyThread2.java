package multithreadingresource;

public class MyThread2 extends Thread {
	
	private MyResource1 myResource1;
	
	
	public MyThread2() {
		super();
	}


	public MyThread2(MyResource1 myResource1) {
		super();
		this.myResource1 = myResource1;
	}


	@Override
	public void run() {
		for(int i=1; i<=100000; i++)
		{
			myResource1.increment();
		}
	}

}
