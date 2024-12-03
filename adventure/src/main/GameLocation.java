package main;

import java.util.Random;

public abstract class GameLocation {
	private int y;
	private int x;
	
	public void setLocation(Game g) {
		Random rnd = new Random();
		do {
			this.y = rnd.nextInt(g.YSIZE);
			this.x = rnd.nextInt(g.XSIZE);
		} while (!g.map[this.y][this.x].equals("."));
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}
