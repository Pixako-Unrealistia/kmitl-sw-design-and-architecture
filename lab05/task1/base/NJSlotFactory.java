
public class NJSlotFactory extends SlotFactory {

	protected Slot makeSlot(String item) {
		Slot slot=null;
		SlotComponentFactory componentFactory = new NJSlotComponentFactory();
		if (item.equals("bonus")) {
			slot=new BonusSlot(componentFactory);
			slot.setName("New Jersey Style Bonus Slot");
		}
		else if (item.equals("progressive")) {
			slot=new ProgressiveSlot(componentFactory);
			slot.setName("New Jersey Style Progressive Slot");
		}
		return slot;
	}
}