package main.java;

public class Dragon extends Monster {
	public Dragon(String type, Game game) {
		this(type, "口から炎を噴き出した", 30, 50, game);
	}
	public Dragon(String type, String attackText, int maxAp, int gold, Game game) {
		super(type, attackText, maxAp, gold, game);
	}
	

}
