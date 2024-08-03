

public class SlotComponentFactoryImpl implements SlotComponentFactory {

	@Override
	public Cabinet createCabinet(String cabi) {
		if (cabi.equals("Medium")) {
			return new mediumCabinet();
		} else if (cabi.equals("Large")) {
			return new largeCabinet();
		} else if (cabi.equals("Small")) {
			return new smallCabinet();
		} else {
			throw new UnsupportedOperationException(cabi + " is not supported");
		} 
	}

	@Override
	public Payment createPayment(String pay) {
		if (pay.equals("Coins")) {
			return new Coins();
		} else if (pay.equals("Bills")) {
			return new Bills();
		} else if (pay.equals("TicketInTicketout")) {
			return new TicketInTicketOut();
		} else {
			throw new UnsupportedOperationException(pay + " is not supported");
		}
	}

	@Override
	public Display createDisplay(String disp) {
		if (disp.equals("CRT")) {
			return new CRT();
		} else if (disp.equals("LCD")) {
			return new LCD();
		} else if (disp.equals("reels")) {
			return new Reels();
		} else if (disp.equals("VGA")) {
			return new VGA();
		} else {
			throw new UnsupportedOperationException(disp + " is not supported");
		}

	}

	@Override
	public GPU createGPU(String gp) {
		if (gp.equals("ARM")) {
			return new ARM();
		} else if (gp.equals("X86")) {
			return new X86();
		} else if (gp.equals("X77")) {
			return new X77();
		} else {
			throw new UnsupportedOperationException(gp + " is not supported");
		}
	}

	@Override
	public OS createOS(String o) {
		if (o.equals("linux")) {
			return new Linux();
		} else if (o.equals("windowsME")) {
			return new WindowsME();
		} else if (o.equals("windowsXP")) {
			return new WindowsXP();
		} else if (o.equals("android")) {
			return new Android();
		} else if (o.equals("symbian")) {
			return new Symbian();
		} else {
			throw new UnsupportedOperationException(o + " is not supported");
		}

	}

}