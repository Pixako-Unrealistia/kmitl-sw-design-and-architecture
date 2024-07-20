package lab03.task3;

public class NevadaSlotMachineFactory extends SlotMachineFactory {

    @Override
    public SlotMachine createSlotMachine(SlotMachineType type) {
        switch (type) {
            case STRAIGHT:
                return new StraightSlot("Nevada", "Large", "ticketinticketout", "reels", "ARM", "Linux", "STRAIGHT");
            case BONUS_GAME:
                return new BonusGameSlot("Nevada", "Small", "ticketinticketout", "CRT", "X86", "Linux", "BONUS_GAME");
            case PROGRESSIVE:
                return new ProgressiveSlot("Nevada", "Medium", "ticketinticketout", "LCD", "X77", "Android", "PROGRESSIVE");
            default:
                return null;
        }
    }
}
