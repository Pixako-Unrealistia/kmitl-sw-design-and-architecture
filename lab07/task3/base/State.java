/**
 * State.java
 *
 * This file represents the different transitions
 * between all states.
 */
public interface State {
	public boolean pressPlay();
	public boolean pressPause();
	public boolean pressStop();
}
