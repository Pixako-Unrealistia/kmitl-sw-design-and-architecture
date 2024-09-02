public class BarProducer extends Thread {
	private String barType;
	public int count = 0; // each producer creates 50 bars
	public int id;

	public BarProducer(int identifier, String barType) {
		this.id = identifier;
		this.barType = barType;
		System.out.println("Creating new Bar Producer with ID: " + id);
	}

	public void run() {
		while (count < 50) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			ChocolateBarFactory factory = ChocolateBarFactory.getInstance();
			Bar bar = factory.create(barType);
			System.out.println("Producer " + id + " created " + bar);
		}
	}
}