public class SingletonfactoryTest {
	public static void main(String[] args) {
			BarProducer producer1 = new BarProducer(1, "Wonka Bar");
			BarProducer producer2 = new BarProducer(2, "Oompaloompa Bar");

			producer1.start();
			producer2.start();

			try {
				producer1.join();
				producer2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
