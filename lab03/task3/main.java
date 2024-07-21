package lab03.task3;

public class main{
    public static void main(String[] args) {
        SlotMachineFactory nevadaFactory = new NevadaSlotMachineFactory();

        SlotMachine nevadaStraight = nevadaFactory.createSlotMachine(SlotMachineFactory.SlotMachineType.STRAIGHT);
        SlotMachine nevadaBonus = nevadaFactory.createSlotMachine(SlotMachineFactory.SlotMachineType.BONUS_GAME);
        SlotMachine nevadaProgressive = nevadaFactory.createSlotMachine(SlotMachineFactory.SlotMachineType.PROGRESSIVE);


        System.out.println(nevadaStraight);
        System.out.println(nevadaBonus);
        System.out.println(nevadaProgressive);
    }
}
