public class Rewind implements State {
    private RemoteDevice remote;

    public Rewind(RemoteDevice remote) {
        this.remote = remote;
        this.remote.setPosition(0);

        // we are at the beginning of the media
        // change the state to stopped
        System.out.println("The player is now stopped.");
        remote.setState(remote.getStoppedState());
    }

    // the Play button is pressed
    public boolean pressPlay() {
        System.out.println("The player is playing.");
        remote.setState(remote.getPlayingState());

        return true;
    }

    public boolean pressPause() {
        System.out.println("The player is paused.");
        remote.setState(remote.getPausedState());

        return true;
    }

    public boolean pressStop() {
        System.out.println("The player is stopped.");
        remote.setState(remote.getStoppedState());
        remote.setPosition(0);

        return true;
    }

    public boolean pressRewind() {
        System.out.println("The player is already rewinding.");

        return false;
    }

    public boolean pressLock() {
        System.out.println("The player is now locked.");
        remote.setState(remote.getLockedState());

        return true;
    }
}
