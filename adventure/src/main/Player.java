package main;

public class Player extends GameLocation {
	String name;
	int hp;
	
	public Player(String name) {
		this.name = name;
		this.hp = 100;
	}
	public void printNowPlace() {
		System.out.println(this.name + "[" + this.y + ":" + this.x + "]");
	}
	public void move(String dir, Game g) {
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(g); }
		case "n" -> { moveUp(); }
		case "s" -> { moveDown(g); }
		}
		printNowPlace();
	}
	public void moveLeft() {
		this.x -= 1;
		if (this.x < 0) this.x = 0;
	}
	public void moveRight(Game g) {
		this.x += 1;
		if (this.x >= g.XSIZE) this.x = g.XSIZE - 1;
	}
	public void moveUp() {
		this.y -= 1;
		if (this.y < 0) this.x = 0;
	}
	public void moveDown(Game g) {
		this.y += 1;
		if (this.y >= g.YSIZE) this.y = g.YSIZE - 1;
	}
	
}
