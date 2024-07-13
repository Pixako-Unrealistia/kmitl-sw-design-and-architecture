
public class TestGuitarHero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			GameCharacter player1 = new GameCharacterSlash();
			GameCharacter player2 = new GameCharacterHendrix();
			player1.playGuitar();
			player2.playGuitar();
			player1.playSolo();
			player2.playSolo();
			player1.change();
			player1.playGuitar();
			}
	}

