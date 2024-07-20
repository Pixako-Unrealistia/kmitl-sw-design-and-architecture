package lab03.task3;

public class WashingtonSlotMachineFactory extends SlotMachineFactory {

    @Override
    public SlotMachine createSlotMachine(SlotMachineType type) {
        switch (type) {
            case STRAIGHT:
                return new StraightSlot("Washington", "Large", "bills", "reels", "ARM", "Linux","STRAIGHT");
            case BONUS_GAME:
                return new BonusGameSlot("Washington", "Medium", "ticketinticketout", "VGA", "ARM", "Symbian", "BONUS_GAME");
            case PROGRESSIVE:
                return new ProgressiveSlot("Washington", "Large", "coins", "reels", "ARM", "Android", "PROGRESSIVE");
            default:
                return null;
        }
    }
}
