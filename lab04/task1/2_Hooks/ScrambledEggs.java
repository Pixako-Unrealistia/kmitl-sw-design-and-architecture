public class ScrambledEggs extends EggMenu {
	@Override
	public void prepare() {
		System.out.println("Stirring and adding milk to the eggs");
	}

	@Override
	public void cook() {
		System.out.println("Scrambling the eggs.");
	}

	@Override
	public void serve() {
		System.out.println("Placing the eggs on the plate.");
	}
}