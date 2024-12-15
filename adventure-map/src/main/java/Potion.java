package main.java;

public class Potion extends Item {
	private int rp;
	
	public Potion(String type, Game game) {
		this(type, 100, game);
	}
	public Potion(String type, int rp, Game game) {
		super(type, game);
		this.rp = rp;
	}
	
	public int getRp() {
		return this.rp;
	}
}
