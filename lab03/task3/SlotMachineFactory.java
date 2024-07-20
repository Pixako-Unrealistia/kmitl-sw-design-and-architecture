package lab03.task3;

public abstract class SlotMachineFactory {

    public enum SlotMachineType {
        STRAIGHT, BONUS_GAME, PROGRESSIVE
    }

    public abstract SlotMachine createSlotMachine(SlotMachineType type);

    // public SlotMachine createSlotMachine(String state, SlotMachineType type) {
    //     SlotMachine slotMachine = null;
    //     switch (state) {
    //         case "Nevada":
    //             switch (type) {
    //                 case STRAIGHT:
    //                     slotMachine = new StraightSlot(state, "Large", "ticketinticketout", "reels", "ARM", "Linux");
    //                     break;
    //                 case BONUS_GAME:
    //                     slotMachine = new BonusGameSlot(state, "Small", "ticketinticketout", "CRT", "X86", "Linux");
    //                     break;
    //                 case PROGRESSIVE:
    //                     slotMachine = new ProgressiveSlot(state, "Medium", "ticketinticketout", "LCD", "X77", "Android");
    //                     break;
    //             }
    //             break;
    //         case "New Jersey":
    //             switch (type) {
    //                 case STRAIGHT:
    //                     slotMachine = new StraightSlot(state, "Small", "coins", "LCD", "ARM", "Window ME");
    //                     break;
    //                 case BONUS_GAME:
    //                     slotMachine = new BonusGameSlot(state, "Large", "coins", "reels", "ARM", "Window ME");
    //                     break;
    //                 case PROGRESSIVE:
    //                     slotMachine = new ProgressiveSlot(state, "Small", "bills", "CRT", "X86", "Window XP");
    //                     break;
    //             }
    //             break;
    //         case "Washington":
    //             switch (type) {
    //                 case STRAIGHT:
    //                     slotMachine = new StraightSlot(state, "Large", "bills", "reels", "ARM", "Linux");
    //                     break;
    //                 case BONUS_GAME:
    //                     slotMachine = new BonusGameSlot(state, "Medium", "ticketinticketout", "VGA", "ARM", "Symbian");
    //                     break;
    //                 case PROGRESSIVE:
    //                     slotMachine = new ProgressiveSlot(state, "Large", "coins", "reels", "ARM", "Android");
    //                     break;
    //             }
    //             break;
    //     }

    //     return slotMachine;
    // }
}
