package main;

public class Ether extends Item {
	private int rmp;
	
	public Ether(String type, int rmp, Game game) {
		super(type, game);
		this.rmp = rmp;
	}
	public Ether(String type, Game game) {
		this(type, 100, game);
	}
	
	public int getRmp() {
		return this.rmp;
	}
}
