package main;

public class Player extends GameLocation {
	String name;
	int hp;
	
	public Player(String name) {
		this.name = name;
		this.hp = 100;
	}
	public void move(String dir, Game g) {
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(g); }
		}
	}
	public void moveLeft() {
		this.x -= 1;
		if (this.x < 0) { this.x = 0;	}
	}
	public void moveRight(Game g) {
		this.x += 1;
		if (this.x >= g.XSIZE) { this.x = g.XSIZE - 1;	}
	}
}
