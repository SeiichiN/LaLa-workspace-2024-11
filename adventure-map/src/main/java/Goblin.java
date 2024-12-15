package main.java;

public class Goblin extends Monster {
	public Goblin(String type, Game game) {
		this(type, "斧で斬りつけた", 20, 30, game);
	}
	public Goblin(String type, String attackText, int maxAp, int gold, Game game) {
		super(type, attackText, maxAp, gold, game);
	}

}
