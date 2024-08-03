
public class NJSlotFactory extends SlotFactory {

	@Override
	protected Slot makeSlot(String item) {
		Slot slot = null;
		SlotComponentFactory componentFactory = new NJSlotComponentFactory();
		if (item.equals("bonus")) {
			slot=new BonusSlot(componentFactory);
			slot.setName("New Jersey Style Bonus Slot");
		}
		else if (item.equals("progressive")) {
			slot=new ProgressiveSlot(componentFactory);
			slot.setName("New Jersey Style Progressive Slot");
		}
		else if (item.equals("straight")) {
			slot=new StraightSlot(componentFactory);
			slot.setName("New Jersey Style Straight Slot");
		}
		return slot;
	}
}