
public class NJSlotComponentFactory implements SlotComponentFactory {
    @Override
    public Cabinet createCabinet(String cabi) {
        switch (cabi) {
            case "Large":
                return new largeCabinet();
            case "Small":
                return new smallCabinet();
            default:
                return null;
        }
    }

    @Override
    public Payment createPayment(String pay) {
        switch (pay) {
            case "Coins":
                return new Coins();
            case "Bills":
                return new Bills();
            default:
                return null;
        }
    }

    @Override
    public Display createDisplay(String disp) {
        switch (disp) {
            case "LCD":
                return new LCD();
            case "reels":
                return new Reels();
            case "CRT":
                return new CRT();
            default:
                return null;
        }
    }

    @Override
    public GPU createGPU(String gp) {
        switch (gp) {
            case "ARM":
                return new ARM();
            case "X86":
                return new X86();
            default:
                return null;
        }
    }

    @Override
    public OS createOS(String o) {
        switch (o) {
            case "WindowsME":
                return new WindowsME();
            case "WindowsXP":
                return new WindowsXP();
            default:
                return null;
        }
    }
}
