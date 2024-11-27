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
	
	public void setLocation() {
		Random rnd = new Random();
		Game g = new Game();
		this.y = rnd.nextInt(g.YSIZE);
		this.x = rnd.nextInt(g.XSIZE);
		System.out.println(g.map[y][x]);
	}
}
