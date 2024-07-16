package lab02.task2.PULL;

import java.util.*;

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
        mdata.addObserver(this);
    }

    public void display(Baby d) {
        // get the state of the baby(crying or not)
        boolean crying = d.getCrying();
        // if the baby is crying, print a message. if not, ignore
        if (crying) {
            System.out.println("Monitor:" + name + " baby is crying");
        }
    }

    public void turnOff() {
        // remove the monitor from the subject
        mdata.deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        // update the state of the baby
        display((Baby) o);
    }
}
