
public class RemoteDeviceV1 {
	public enum State {
		PLAYING, PAUSED, STOPPED
	};

	State currentState = State.STOPPED;

	public void pressPlay() {
		if (currentState == State.PLAYING)
			System.out.println("The player is already playing.");
		else if (currentState == State.PAUSED) {
			currentState = State.PLAYING;
			System.out.println("The player is now playing.");
		} else if (currentState == State.STOPPED) {
			currentState = State.PLAYING;
			System.out.println("The player is now playing.");
		}
	}

	public void pressPause() {
		if (currentState == State.PAUSED)
			System.out.println("The player is already paused.");
		else if (currentState == State.PLAYING || currentState == State.STOPPED) {
			currentState = State.PAUSED;
			System.out.println("The player is paused.");
		}
	}

	public void pressStop() {
		if (currentState == State.STOPPED)
			System.out.println("The player is already stopped.");
		else if (currentState == State.PLAYING || currentState == State.PAUSED) {
			currentState = State.STOPPED;
			System.out.println("The player is now stopped.");
		}
	}

}
