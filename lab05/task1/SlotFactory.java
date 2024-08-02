public abstract class SlotFactory {

	public  Slot orderSlot(String type) {
		Slot slot = makeSlot(type);
		System.out.println("--- Making a " + slot.getName() + " ---");
		slot.build();
		slot.collectParts();
		slot.assembleParts();
		slot.test("hardware");
		slot.uploadSoftware();
		slot.test("software");
		slot.ship();
		return slot;
	}
	abstract Slot makeSlot(String type);
}