public abstract class EggMenu {

	final public void makeEggMenu(int num) {
		crackEggs(num);
		prepare();
		cook();
		serve();
	}

	final public void crackEggs(int num) {
		System.out.println("Cracking " + num + " eggs");
	}

	public abstract void prepare();
	public abstract void cook();
	
	final public void serve() {
		System.out.println("Placing the eggs on a plate");
	}
}