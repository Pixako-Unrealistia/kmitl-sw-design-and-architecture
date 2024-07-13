package lab02.task2.PULL;

public interface Subject {
    // add an observer to the list
    public void registerObserver(Observer o);

    // remove an observer from the list
    public void removeObserver(Observer o);

    // notify all observers when the state of the subject change
    public void notifyObservers();
}
