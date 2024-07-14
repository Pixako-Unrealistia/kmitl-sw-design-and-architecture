
public class TestGuitarHero {
	public static void main(String[] args) {
			GameCharacter player1 = new GameCharacterSlash();
			GameCharacter player2 = new GameCharacterHendrix();
			GameCharacter player3 = new GameCharacterYoung();

			player1.playGuitar();
			player1.playSolo();
			player2.playGuitar();


			player2.playSolo();
			player3.playGuitar();
			player3.playSolo();

			System.out.println("\n\033[31;1;4mChanging Guitar for all\033[0m\n");

			player1.change();
			player2.change();
			player3.change();

			player1.playGuitar();
			player1.playSolo();
			player2.playGuitar();
			player2.playSolo();
			player3.playGuitar();
			player3.playSolo();
			
			}
	}


