public class Main {
	public static void main(String[] args) {
		SlotFactory slotFactory = new NJSlotFactory();

		Slot bonusSlot = slotFactory.makeSlot("bonus");
		System.out.println(bonusSlot.getName());

		Slot progressiveSlot = slotFactory.makeSlot("progressive");
		System.out.println(progressiveSlot.getName());

		Slot straightSlot = slotFactory.makeSlot("straight");
		System.out.println(straightSlot.getName());

		slotFactory = new NVSlotFactory();

		bonusSlot = slotFactory.makeSlot("bonus");
		System.out.println(bonusSlot.getName());

		progressiveSlot = slotFactory.makeSlot("progressive");
		System.out.println(progressiveSlot.getName());

		straightSlot = slotFactory.makeSlot("straight");
		System.out.println(straightSlot.getName());

		slotFactory = new WSlotFactory();

		bonusSlot = slotFactory.makeSlot("bonus");
		System.out.println(bonusSlot.getName());

		progressiveSlot = slotFactory.makeSlot("progressive");
		System.out.println(progressiveSlot.getName());

		straightSlot = slotFactory.makeSlot("straight");
		System.out.println(straightSlot.getName());

		
	}
}