
public class NJSlotComponentFactory implements SlotComponentFactory {

	public Cabinet createCabinet() {
		return new smallCabinet();
	}
	public Display createDisplay() {
		return new Reels();
	}

	public OS createOS() {
		return new WindowsME();
	}

	public Payment createPayment() {
		return new Coins();
	}

	public GPU createGPU() {
		return new ARM();
	}
}
