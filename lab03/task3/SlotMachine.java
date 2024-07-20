package lab03.task3;

public abstract class SlotMachine {
    String state;
    String cabinet;
    String paymentSystem;
    String display;
    String cpu;
    String os;

    @Override
    public String toString() {
        return "SlotMachine{" +
                "state=" + state +
                ", cabinet='" + cabinet + '\'' +
                ", paymentSystem='" + paymentSystem + '\'' +
                ", display='" + display + '\'' +
                ", cpu='" + cpu + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
    
