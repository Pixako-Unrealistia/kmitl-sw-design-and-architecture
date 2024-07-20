package lab03.task3;

public class WashingtonSlotMachineFactory extends SlotMachineFactory {

    @Override
    public SlotMachine createSlotMachine(SlotMachineType type) {
        switch (type) {
            case STRAIGHT:
                return new WashingtonStraightSlot();
            case BONUS_GAME:
                return new WashingtonBonusGameSlot();
            case PROGRESSIVE:
                return new WashingtonProgressiveSlot();
            default:
                return null;
        }
    }
}
