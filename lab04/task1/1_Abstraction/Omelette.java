public class Omelette extends EggMenu {
	@Override
	public void prepare() {
		System.out.println("Stirring the eggs");
	}
	
	@Override
	public void cook() {
		System.out.println("Flipping the omelette while cooking");
	}
	
	@Override
	public void serve() {
		System.out.println("Putting the eggs on the plate");
	}
}
