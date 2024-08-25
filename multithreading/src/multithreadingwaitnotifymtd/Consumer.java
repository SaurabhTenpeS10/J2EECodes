package multithreadingwaitnotifymtd;

public class Consumer extends Thread {
	private Product product;

	public Consumer() {
		super();
	}

	public Consumer(Product product) {
		super();
		this.product = product;
	}
	
	@Override
	public void run() {
		product.demand(10);
	}
}
