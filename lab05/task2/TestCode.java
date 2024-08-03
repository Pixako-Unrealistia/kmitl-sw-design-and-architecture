import java.util.ArrayList;
public class TestCode {
    public static void main(String[] args) {
        SlotFactory njFactory = new NJSlotFactory();
        SlotFactory nvFactory = new NVSlotFactory();
        SlotFactory wFactory = new WSlotFactory();
        ArrayList<String> slotTypes = new ArrayList<String>();
        slotTypes.add("bonus");
        slotTypes.add("progressive");
        slotTypes.add("straight");
        for (String slotType : slotTypes) {
            System.out.println("Calling NJSlotFactory to order a " + slotType + " slot");
            Slot slot = njFactory.orderSlot(slotType);
            System.out.println("\n" + slot + "\n");

            System.out.println("Calling NVSlotFactory to order a " + slotType + " slot");
            Slot slot2 = nvFactory.orderSlot(slotType);
            System.out.println("\n" + slot2 + "\n");

            System.out.println("Calling WSlotFactory to order a " + slotType + " slot");
            Slot slot3 = wFactory.orderSlot(slotType);
            System.out.println("\n" + slot3 + "\n");
        }

    }
}
