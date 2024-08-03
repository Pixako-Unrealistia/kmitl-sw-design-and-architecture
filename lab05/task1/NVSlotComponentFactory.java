
public class NVSlotComponentFactory implements SlotComponentFactory {

	public Cabinet createCabinet() {
		return new largeCabinet();
	}
	public Display createDisplay() {
		return new LCD();
	}

	public OS createOS() {
		return new Android();
	}

	public Payment createPayment() {
		return new TicketInTicketOut();
	}

	public GPU createGPU() {
		return new X86();
	}
	
}
