public class SingletonfactoryTest {
	public static void main(String[] args) {
		BarProducer t1 = new BarProducer(1);
		BarProducer t2 = new BarProducer(2);
		t1.start();
		t2.start();
		//t1.interrupt();
		//t1.interrupt();
	}
}
