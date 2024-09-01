public class Logger {
	
	private static Logger uniqueInstance = new Logger(); // eagerly created instance
	private int loggedmessages;
	
	private Logger() {
		loggedmessages=0;
	}
	
	public static synchronized Logger getInstance() {
		if (uniqueInstance==null) {
			uniqueInstance= new Logger();
		}
		return uniqueInstance;
   }
	
	public synchronized void log( String msg ) 
	{
	 loggedmessages++;
	 System.out.println("LOG:" + loggedmessages + " " + msg); 
	}
}
