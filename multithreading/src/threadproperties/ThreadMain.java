package threadproperties;

public class ThreadMain {
	public static void main(String[] args) {
		
		MyThread1 myThread1 = new MyThread1();
		
		myThread1.setName("MyThread");
		myThread1.setPriority(8);
		
		myThread1.start();
		
	}
}
