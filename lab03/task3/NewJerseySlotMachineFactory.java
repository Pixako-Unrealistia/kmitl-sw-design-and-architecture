package lab03.task3;

public class NewJerseySlotMachineFactory extends SlotMachineFactory {

    @Override
    public SlotMachine createSlotMachine(SlotMachineType type) {
        switch (type) {
            case STRAIGHT:
                return new StraightSlot("New Jersey", "Small", "coins", "LCD", "ARM", "Window ME", "STRAIGHT");
            case BONUS_GAME:
                return new BonusGameSlot("New Jersey", "Large", "coins", "reels", "ARM", "Window ME", "BONUS_GAME");
            case PROGRESSIVE:
                return new ProgressiveSlot("New Jersey", "Small", "bills", "CRT", "X86", "Window XP", "PROGRESSIVE");
            default:
                return null;
        }
    }
}
