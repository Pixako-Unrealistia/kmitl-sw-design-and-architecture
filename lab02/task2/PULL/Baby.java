package lab02.task2.PULL;

import java.util.ArrayList;
import java.util.*;

public class Baby extends Observable {

    // the state of the baby(crying or not)
    private boolean crying = false;
    // the level of the baby's crying(for advanced monitor)
    private int level = 0;
    // the name of the baby
    private String babyname;

    public Baby(String name) {
        // set the name of the baby
        this.babyname = name;
        // initialize the list of observers(empty list)
    }

    public void setData(boolean crying, int level) {
        // update the state of the baby
        this.crying = crying;
        this.level = level;
        // notify all of the observers

        this.setChanged();
        notifyObservers();
    }

    // THIS IS FOR PULL STRATEGY
    public boolean getCrying() {
        return crying;
    }

    public int getLevel() {
        return level;
    }

    public String getBabyName() {
        return babyname;
    }
}
