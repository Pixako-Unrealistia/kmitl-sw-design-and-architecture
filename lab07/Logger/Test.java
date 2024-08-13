public class Test extends Thread {
	private int id;
	private int count=0; // test counts
	
	public Test(int identifier) {
		id=identifier;
		System.out.println("creating new Test Thread with ID:"+id);
	}
	
	public void run()                       
    {     	
			while (count<10) {
				try {
					sleep(100);
				} catch (InterruptedException e) {}
				count++;
				Logger.getInstance().log("Thread: "+id +" writes " + count + "th msg to log");
			}
	      }
    }

