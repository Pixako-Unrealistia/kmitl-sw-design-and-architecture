package lab03.task3;

public abstract class SlotMachine {
    String state;
    String cabinet;
    String paymentSystem;
    String display;
    String cpu;
    String os;
    String type;

    public SlotMachine(String state, String cabinet, String paymentSystem, String display, String cpu, String os, String type) {
        this.state = state;
        this.cabinet = cabinet;
        this.paymentSystem = paymentSystem;
        this.display = display;
        this.cpu = cpu;
        this.os = os;
        this.type = type;
    }

    @Override
    public String toString() {
        return "SlotMachine{" +
                "state='" + state + '\'' +
                ", cabinet='" + cabinet + '\'' +
                ", paymentSystem='" + paymentSystem + '\'' +
                ", display='" + display + '\'' +
                ", cpu='" + cpu + '\'' +
                ", os='" + os + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
