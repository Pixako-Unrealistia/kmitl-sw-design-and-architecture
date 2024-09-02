public class Locked implements State {
    private RemoteDevice remote;

    public Locked(RemoteDevice remote) {
        this.remote = remote;
    }

    public boolean pressPlay() {
        System.out.println("The player is currently locked, You cannot press play.");
        return false;
    }

    public boolean pressPause() {
        System.out.println("The player is currently locked, You cannot press pause.");
        return false;
    }

    public boolean pressStop() {
        System.out.println("The player is currently locked, You cannot press stop.");
        return false;
    }

    public boolean pressRewind() {
        System.out.println("The player is currently locked, You cannot press rewind.");
        return false;
    }

    public boolean pressLock() {
        System.out.println("The player is now Unlocked.");
        remote.setState(remote.getPausedState());
        return true;
    }

}
