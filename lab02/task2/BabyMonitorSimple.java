package lab02.task2;

public class BabyMonitorSimple implements Observer {
    // the subject to observe
    private Subject mdata;
    // the name(location) of the monitor
    private String name;
    // the state of the baby(crying or not)
    private boolean crying;

    public BabyMonitorSimple(String location, Baby d) {
        // set the subject to observe
        this.mdata = d;
        // set the name of the monitor
        this.name = location;
        // register the monitor to the subject
        mdata.registerObserver(this);
    }

    public void display() {
        // if the baby is crying, print a message. if not, ignore
        if (crying) {
            System.out.println("Monitor:" + name + " baby is crying");
        }
    }

    public void turnOff() {
        // remove the monitor from the subject
        mdata.removeObserver(this);
    }

    // this function will recieve all of the data from the subject(PUSH strategy)
    // when the state of the subject changes
    public void update(String name, boolean crying, int level) {
        // update the state of the baby
        this.crying = crying;
        // display the state of the baby(if crying, print a message)
        display();
    }
}
