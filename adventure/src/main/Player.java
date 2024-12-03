package main;

public class Player extends GameLocation {
	private String name;
	private int hp;
	
	public Player(String name) {
		this.name = name;
		this.hp = 100;
		setLocation();
	}
	
	public void attack(Monster m) {
		if (this.hp <= 0) { return; }
		System.out.println(this.getName() + "は剣で切りつけた。");
		int ap = (int)Math.floor(Math.random() * 31);
		m.setHp(m.getHp() - ap);
		System.out.println(m.getType() + "に" + ap + "ポイントのダメージ");
		if (m.getHp() <= 0) {
			System.out.println(m.getType() + "を倒した。");
		}		
	}
	
	public void look() {
		System.out.print("[" + getY() + ":" + getX() + "] ");
		System.out.println(Game.map[getY()][getX()]);
	}
	
	public String toString() {
		return name + " HP:" + hp;
	}
	
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void move(String dir) {
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(); }
		case "n" -> { moveUp(); }
		case "s" -> { moveDown(); }
		}
	}
	private void moveLeft() {
		this.setX(this.getX() - 1);
		if (this.getX() < 0) { this.setX(0);	}
	}
	private void moveRight() {
		this.setX(this.getX() + 1);
		if (this.getX() >= Game.XSIZE) { this.setX(Game.XSIZE - 1);	}
	}
	private void moveUp() {
		this.setY(this.getY() - 1);
		if (this.getY() < 0) { this.setY(0);	}
	}
	private void moveDown() {
		this.setY(this.getY() + 1);
		if (this.getY() >= Game.YSIZE) { this.setY(Game.YSIZE - 1);	}
	}
}
