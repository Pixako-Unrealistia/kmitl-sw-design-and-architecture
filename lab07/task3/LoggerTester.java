
public class LoggerTester {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		System.out.println("Testing Logger");
		Test t1 = new Test(1); 
		Test t2 = new Test(2); 
		t1.start();
		t2.start();
	}
}
