
public class BonusSlot extends Slot {
	SlotComponentFactory componentFactory;
	
	public BonusSlot(SlotComponentFactory componentFactory) {
		this.componentFactory= componentFactory;
	}
 
	void build() {
		System.out.println("Building " + name);
		cabinet = componentFactory.createCabinet();
		display = componentFactory.createDisplay();
	}
}
