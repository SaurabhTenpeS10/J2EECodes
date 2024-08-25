package multithreadingwaitnotifymtd;

public class Producer extends Thread {
	private Product product;

	
	
	public Producer() {
		super();
	}



	public Producer(Product product) {
		super();
		this.product = product;
	}
	
	@Override
	public void run() {
		product.supply(10);
	}
	
}
