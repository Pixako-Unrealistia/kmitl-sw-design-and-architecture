package lab03.task3;

public abstract class SlotMachineFactory {

    public enum SlotMachineType {
        STRAIGHT, BONUS_GAME, PROGRESSIVE
    }

    public abstract SlotMachine createSlotMachine(SlotMachineType type);
}
