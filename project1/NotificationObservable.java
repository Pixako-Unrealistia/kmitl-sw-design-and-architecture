import java.util.Observable;

public class NotificationObservable extends Observable {
    public void notifyObservers(String message) {
        setChanged();
        super.notifyObservers(message);
    }

}
