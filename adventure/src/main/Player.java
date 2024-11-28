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
	
	public void setLocation(Game g) {
		Random rnd = new Random();
		do {
			this.y = rnd.nextInt(g.YSIZE);
			this.x = rnd.nextInt(g.XSIZE);
		} while (!g.map[this.y][this.x].equals("."));
		System.out.println(g.map[y][x]);
	}
}
