
public class TestDrive {
	public static void main(String[] args) {

		// what about a singleton here???
		RemoteDevice remote = new RemoteDevice();

		remote.pressPlay();

		remote.pressPause();

		remote.pressStop();
		remote.pressPause();

		remote.pressPlay();
		remote.pressPlay();

		remote.pressStop();
		remote.pressRewind();

		// play again
		remote.pressPlay();
		// lock
		remote.pressLock();
		// try to pause
		remote.pressPause();
		// unlock
		remote.pressLock();
		// pause
		remote.pressStop();

	}

}
