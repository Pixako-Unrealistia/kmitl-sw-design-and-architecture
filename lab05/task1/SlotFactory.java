public abstract class SlotFactory {

	public  Slot orderSlot(String type) {
		Slot slot = makeSlot(type);
		
		String _name = slot.getName();
		System.out.println("--- Making a " + _name + " ---");


		if ("Nevada Style Straight Slot".equals(_name) && "straight".equals(type)) {
			slot.build("Large", "TicketInTicketOut", "Reels", "ARM", "Linux");
		}
		else if ("Nevada Style Bonus Slot".equals(_name) && "bonus".equals(type)) {
			slot.build("Small", "TicketInTicketOut", "CRT", "X86", "Linux");
		}
		else if ("Nevada Style Progressive Slot".equals(_name) && "progressive".equals(type)) {
			slot.build("Medium", "TicketInTicketOut", "LCD", "X77", "Android");
		}	
		
		else if ("New Jersey Style Straight Slot".equals(_name) && "straight".equals(type)) {
			slot.build("Small", "Coins", "LCD", "ARM", "WindowsME");
		}
		else if ("New Jersey Style Bonus Slot".equals(_name) && "bonus".equals(type)) {
			slot.build("Large", "Coins", "Reels", "ARM", "WindowsME");
		}
		else if ("New Jersey Style Progressive Slot".equals(_name) && "progressive".equals(type)) {
			slot.build("Small", "Bills", "CRT", "X86", "WindowsXP");
		}

		else if ("Washington Style Straight Slot".equals(_name) && "straight".equals(type)) {
			slot.build("Large", "Bills", "Reels", "ARM", "Linux");
		}
		else if ("Washington Style Bonus Slot".equals(_name) && "bonus".equals(type)) {
			slot.build("Medium", "TicketInTicketOut", "VGA", "ARM", "Symbian");
		}
		else if ("Washington Style Progressive Slot".equals(_name) && "progressive".equals(type)) {
			slot.build("Large", "Coins", "Reels", "ARM", "Android");
		}
		else {
			System.out.println("Invalid slot type");
		}




		
		//slot.build();
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