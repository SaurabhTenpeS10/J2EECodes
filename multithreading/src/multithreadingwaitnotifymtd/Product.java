package multithreadingwaitnotifymtd;

public class Product {
	private int count;
	synchronized public void demand(int count) {
		if(count <=this.count) {
			System.out.println("Product Available");
			this.count -= count;
			System.out.println("Product Delivered");
		}
		else {
			System.out.println("Shortage of Products");
			System.out.println("Wait for Sometime..");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(this.count>=count) {
			System.out.println("Product Available");
			this.count -= count;
			System.out.println("Product Delivered");
		}
	}
	synchronized public void supply(int count) {
		this.count += count;
		notify();
	}
	
}
