package game;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameImpl game = GameImpl.valueOf(3, 4);
		game.run();
	}

}
