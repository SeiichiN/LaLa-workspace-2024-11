package main;

import java.util.Random;

public abstract class GameLocation {
	int y;
	int x;
	
	public void setLocation() {
		Random rnd = new Random();
		do {
			this.y = rnd.nextInt(Game.YSIZE);
			this.x = rnd.nextInt(Game.XSIZE);
		} while (!Game.map[this.y][this.x].equals("."));
	}

}
