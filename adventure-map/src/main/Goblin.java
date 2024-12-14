package main;

public class Goblin extends Monster {
	public Goblin(String type, Game game) {
		this(type, "斧", 20, game);
	}
	public Goblin(String type, String weapon, int maxAp, Game game) {
		super(type, weapon, maxAp, game);
	}

}
