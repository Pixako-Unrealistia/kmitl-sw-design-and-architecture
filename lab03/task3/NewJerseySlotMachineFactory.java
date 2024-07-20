package lab03.task3;

public class NewJerseySlotMachineFactory extends SlotMachineFactory {

    @Override
    public SlotMachine createSlotMachine(SlotMachineType type) {
        switch (type) {
            case STRAIGHT:
                return new NewJerseyStraightSlot();
            case BONUS_GAME:
                return new NewJerseyProgressiveSlot();
            case PROGRESSIVE:
                return new NewJerseyProgressiveSlot();
            default:
                return null;
        }
    }
}
