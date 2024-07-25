
public class EatBreakfast {
	public static void main(String[] args) {
		ScrambledEggs scrambled = new ScrambledEggs();
		Omelette omelette = new Omelette();
		SunnySide sunny = new SunnySide();
		
		scrambled.makeEggMenu(2);
		omelette.makeEggMenu(3);
		sunny.makeEggMenu(1);

	}

}
