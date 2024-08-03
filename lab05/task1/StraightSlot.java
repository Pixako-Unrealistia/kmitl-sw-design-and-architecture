public class StraightSlot extends Slot {
	SlotComponentFactory componentFactory;
	
	public StraightSlot(SlotComponentFactory componentFactory) {
		this.componentFactory= componentFactory;
	}
 
	void build() {
		System.out.println("Building Straight " + name);
		cabinet = componentFactory.createCabinet();
		display = componentFactory.createDisplay();
	}
}
