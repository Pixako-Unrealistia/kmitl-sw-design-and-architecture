package lab02.task2;

public interface Observer {
    // update the observer with the new state of the subject
    public void update(String babyname, boolean crying, int level);
}
