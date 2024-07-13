package lab02.task2.PULL;

public class BabyMonitorSimple implements Observer {
    // use baby as the subject to observe so that this class can directly access teh
    // data of the baby
    private Baby mdata;
    // the name(location) of the monitor
    private String name;

    public BabyMonitorSimple(String location, Baby d) {
        // set the subject to observe
        this.mdata = d;
        // set the name of the monitor
        this.name = location;
        // register the monitor to the subject
        mdata.registerObserver(this);
    }

    public void display() {
        // get the state of the baby(crying or not)
        boolean crying = mdata.getCrying();
        // if the baby is crying, print a message. if not, ignore
        if (crying) {
            System.out.println("Monitor:" + name + " baby is crying");
        }
    }

    public void turnOff() {
        // remove the monitor from the subject
        mdata.removeObserver(this);
    }

    // (PULL strategy)
    // this function will trigger when the state of the subject changes
    // this function need to pull the data from the subject by itself as there are
    // no arguments
    public void update() {
        // display the state of the baby(if crying, print a message)
        display();
    }
}
