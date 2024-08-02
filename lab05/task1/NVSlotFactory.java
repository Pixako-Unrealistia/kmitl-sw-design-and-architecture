
public class NVSlotFactory extends SlotFactory {

	protected Slot makeSlot(String item) {
		Slot slot=null;
		SlotComponentFactory componentFactory = new NVSlotComponentFactory();
		if (item.equals("bonus")) {
			slot=new BonusSlot(componentFactory);
			slot.setName("Nevada Style Bonus Slot");
		}
		else if (item.equals("progressive")) {
			slot=new ProgressiveSlot(componentFactory);
			slot.setName("Nevada Style Progressive Slot");
		}
		return slot;
	}
}