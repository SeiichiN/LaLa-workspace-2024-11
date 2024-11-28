package main;

import java.util.Random;

public class Monster {
	String type;
	int hp;
	int y;
	int x;
	
	public Monster(String type) {
		this.type = type;
		this.hp = 100;
	}
	
	public void setLocation(Game g) {
		Random rnd = new Random();
		do {
			this.y = rnd.nextInt(g.YSIZE);
			this.x = rnd.nextInt(g.XSIZE);
		} while (!g.map[this.y][this.x].equals("."));
		System.out.println(g.map[y][x]);
		setTypeOnMap(g);
	}
	
	public void setTypeOnMap(Game g) {
		g.map[this.y][this.x] = this.type;
	}
}
