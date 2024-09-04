//Singleton here

import java.util.concurrent.atomic.AtomicInteger;

public class ChocolateBarFactory {
	private static ChocolateBarFactory instance;
	private AtomicInteger uniqueId;

	private ChocolateBarFactory() {
		uniqueId = new AtomicInteger(0);
	}

	public static synchronized ChocolateBarFactory getInstance() {
		if (instance == null) {
			instance = new ChocolateBarFactory();
		}
		return instance;
	}

	public Bar create(String type) {
		int id = uniqueId.incrementAndGet();
		switch (type) {
			case "Wonka Bar":
				return new WonkaBar(id);
			case "Oompaloompa Bar":
				return new OompaloompaBar(id);
			default:
				throw new IllegalArgumentException("Unknown bar type: " + type);
		}
	}
}

