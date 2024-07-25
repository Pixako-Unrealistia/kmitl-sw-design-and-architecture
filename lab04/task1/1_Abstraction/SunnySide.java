public class SunnySide extends EggMenu {
	@Override
	public void prepare() {
		System.out.println("Never stir sunny side up!");
	}

	@Override
	public void cook() {
		System.out.println("Cooking the eggs sunny side up.");
	}

	@Override
	public void serve() {
		System.out.println("Placing the eggs on a plate");
	}
}