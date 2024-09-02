
public class TestDrive {
	public static void main(String[] args) {
		
		// what about a singleton here???
		RemoteDeviceV1 remote = new RemoteDeviceV1();
		
		remote.pressPlay();
		
		remote.pressPause();
		
		remote.pressStop();
		
		remote.pressPlay();
		remote.pressPlay();

	}

}
