package main;

public abstract class Monster extends GameLocation {
	String type;
	int hp;
	
	public Monster(String type) {
		this.type = type;
		this.hp = 100;
	}
	public void setSelfOnMap(Game g) {
		g.map[this.y][this.x] = this.type;
	}
	
	public abstract void attack(Player p);
}
