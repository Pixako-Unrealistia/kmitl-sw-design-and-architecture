
public class NVSlotComponentFactory implements SlotComponentFactory {
    @Override
    public Cabinet createCabinet(String cabi) {
        // Large Small Medium
        switch (cabi) {
            case "Large":
                return new largeCabinet();
            case "Small":
                return new smallCabinet();
            case "Medium":
                return new mediumCabinet();
            default:
                return null;
        }
    }

    @Override
    public Payment createPayment(String pay) {
        // ticketinticketout
        switch (pay) {
            case "TicketInTicketOut":
                return new TicketInTicketOut();
            default:
                return null;
        }
    }

    @Override
    public Display createDisplay(String disp) {
        // reels lcd crt
        switch (disp) {
            case "LCD":
                return new LCD();
            case "Reels":
                return new Reels();
            case "CRT":
                return new CRT();
            default:
                return null;
        }
    }

    @Override
    public GPU createGPU(String gp) {
        // arm x86 x77
        switch (gp) {
            case "ARM":
                return new ARM();
            case "X86":
                return new X86();
            case "X77":
                return new X77();
            default:
                return null;
        }
    }

    @Override
    public OS createOS(String o) {
        // Linux Android
        switch (o) {
            case "Linux":
                return new Linux();
            case "Android":
                return new Android();
            default:
                return null;
        }
    }
}
