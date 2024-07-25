public abstract class EggMenu {
	
	final public void makeEggMenu(int num) {
		crackEggs(num);
		prepare();
		cook();
		if (wantAddSalt()) {
			System.out.println("Adding salt");
		}
		if (wantAddPepper()) {
			System.out.println("Adding pepper");
		}
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

	final boolean wantAddSalt() {
		if (Math.random() < 0.5) {
			return true;
		}
		return false;
	}

	final boolean wantAddPepper() {
		if (Math.random() < 0.5) {
			return true;
		}
		return false;
	}
}