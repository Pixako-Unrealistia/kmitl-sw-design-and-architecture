package lab03.task3;

public class NevadaSlotMachineFactory extends SlotMachineFactory {

    @Override
    public SlotMachine createSlotMachine(SlotMachineType type) {
        switch (type) {
            case STRAIGHT:
                return new NevadaStraightslot();
            case BONUS_GAME:
                return new NevadaBonusGameSlot();
            case PROGRESSIVE:
                return new NevadaProgressiveSlot();
            default:
                return null;
        }
    }
}
