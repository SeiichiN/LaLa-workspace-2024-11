package game;

import java.util.Random;

public abstract class GameLocation {
	private int y;
	private int x;
	private Game game;
	
	public GameLocation(Game game) {
		this.game = game;
		setLocation();
	}
	
	public void setLocation() {
		Random rnd = new Random();
		do {
			this.y = rnd.nextInt(game.YSIZE);
			this.x = rnd.nextInt(game.XSIZE);
		} while (game.getMap()[this.y][this.x] != null);
	}
	
	public int getY() { return this.y; }
	public int getX() { return this.x; }
	public void setY(int y) { this.y = y; }
	public void setX(int x) { this.x = x; }

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
