package threadproperties;

public class MyThread1 extends Thread {
	
	@Override
	public void run() {
		System.out.println("Id= "+this.threadId());
		System.out.println("Name= " + this.getName());
		System.out.println("Priority= " + this.getPriority());
	}
}
