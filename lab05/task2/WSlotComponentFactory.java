public class WSlotComponentFactory implements SlotComponentFactory {

    @Override
    public Cabinet createCabinet(String cabi) {
        // Large Medium
        switch (cabi) {
            case "Large":
                return new largeCabinet();
            case "Medium":
                return new mediumCabinet();
            default:
                return null;
        }
    }

    @Override
    public Payment createPayment(String pay) {
        // ticketinticketout bills coins
        switch (pay) {
            case "TicketInTicketOut":
                return new TicketInTicketOut();
            case "Bills":
                return new Bills();
            case "Coins":
                return new Coins();
            default:
                return null;
        }
    }

    @Override
    public Display createDisplay(String disp) {
        // Reels VGA
        switch (disp) {
            case "Reels":
                return new Reels();
            case "VGA":
                return new VGA();
            default:
                return null;
        }
    }

    @Override
    public GPU createGPU(String gp) {
        // arm
        switch (gp) {
            case "ARM":
                return new ARM();
            default:
                return null;
        }
    }

    @Override
    public OS createOS(String o) {
        // linux android symbian
        switch (o) {
            case "Linux":
                return new Linux();
            case "Android":
                return new Android();
            case "Symbian":
                return new Symbian();
            default:
                return null;
        }
    }
}
