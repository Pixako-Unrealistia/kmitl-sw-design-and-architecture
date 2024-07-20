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

        // result is 
        // SlotMachine{state='Nevada', cabinet='Large', paymentSystem='ticketinticketout', display='reels', cpu='ARM', os='Linux'}
        // SlotMachine{state='Nevada', cabinet='Small', paymentSystem='ticketinticketout', display='CRT', cpu='X86', os='Linux'}
        // SlotMachine{state='Nevada', cabinet='Medium', paymentSystem='ticketinticketout', display='LCD', cpu='X77', os='Android'}
    }
}
