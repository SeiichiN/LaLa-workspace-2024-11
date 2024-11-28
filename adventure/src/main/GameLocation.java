package main;

import java.util.Random;

public abstract class GameLocation {
	int y;
	int x;
	public void setLocation(Game g) {
		Random rnd = new Random();
		do {
			this.y = rnd.nextInt(g.YSIZE);
			this.x = rnd.nextInt(g.XSIZE);
		} while (!g.map[this.y][this.x].equals("."));
		System.out.println(g.map[this.y][this.x]);
	}

}
