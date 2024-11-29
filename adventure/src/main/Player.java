package main;

public class Player extends GameLocation {
	String name;
	int hp;
	
	public Player(String name) {
		this.name = name;
		this.hp = 100;
	}
	public void move(String dir) {
		
	}
	public void moveLeft() {
		// xを-1
		// もしxがマイナスなら x=0 とする
	}
}
