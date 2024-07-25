public abstract class EggMenu {
	public void crackEggs(int num) {
		System.out.println("Cracking " + num + " eggs");
	}

	public abstract void prepare();
	public abstract void cook();
	public abstract void serve();
}