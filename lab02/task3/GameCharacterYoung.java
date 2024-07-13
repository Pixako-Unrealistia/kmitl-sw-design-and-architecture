public class GameCharacterYoung extends GameCharacter {

	public GameCharacterYoung() {
		 guitarBehavior=new Guitar_GibsonSG();
		 soloBehavior=new Solo_JumpOffStage();
	}
	
	public void change() {
		if (guitarBehavior instanceof Guitar_LesPaul) {
			this.setGuitar(new Guitar_GibsonSG());
		} else if (guitarBehavior instanceof Guitar_GibsonSG) {
			this.setGuitar(new Guitar_Telecaster());
		} else if (guitarBehavior instanceof Guitar_Telecaster) {
			this.setGuitar(new Guitar_LesPaul());
		}
	}
	
}