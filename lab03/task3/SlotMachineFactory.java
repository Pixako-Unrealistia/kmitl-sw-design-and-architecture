package lab03.task3;

public abstract class SlotMachineFactory {
    public SlotMachine createSlotMachine(String state) {
        SlotMachine slotMachine = null;
        switch (state) {
            case "Nevada":
                slotMachine = new StraightSlot(state, "Standard Cabinet", "Basic Payment System", "LCD Display", "ARM CPU", "Linux OS");
                break;
            case "Bonus":
                slotMachine = new BonusGameSlot(state, "Deluxe Cabinet", "Advanced Payment System", "LED Display", "Intel CPU", "Windows OS");
                break;
            case "Progressive":
                slotMachine = new ProgressiveSlot(state, "Luxury Cabinet", "Premium Payment System", "OLED Display", "AMD CPU", "Custom OS");
                break;
        }

        return slotMachine;
    }
}
