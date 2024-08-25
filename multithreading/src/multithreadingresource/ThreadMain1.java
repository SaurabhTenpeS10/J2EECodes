package multithreadingresource;

public class ThreadMain1 {

	public static void main(String[] args) {
		MyResource1 myResource1 = new MyResource1();
		
		MyThread1 myThread1 = new MyThread1(myResource1);
		
		MyThread2 myThread2 = new MyThread2(myResource1);
		
		myThread1.start();
		myThread2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(myResource1.getCount());
	}
	
	
	
	
	
}
