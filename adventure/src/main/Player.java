package main;

import java.util.Random;

public class Player {
	String name;
	int hp;
	int y;
	int x;
	
	public Player(String name) {
		this.name = name;
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
