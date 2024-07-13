package lab02.task2;

import java.util.ArrayList;

public class Baby implements Subject {

    // the list of observers
    private ArrayList observers;
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
        observers = new ArrayList();
    }

    public void notifyObservers() {
        // notify all of the observers
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(babyname, crying, level);
        }
    }

    public void registerObserver(Observer o) {
        // add an observer to the list
        observers.add(o);

    }

    public void removeObserver(Observer o) {
        // remove an observer from the list if it exists
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void setData(boolean crying, int level) {
        // update the state of the baby
        this.crying = crying;
        this.level = level;
        // notify all of the observers
        notifyObservers();
    }
}
