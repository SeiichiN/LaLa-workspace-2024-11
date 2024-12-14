package main;

public class Dragon extends Monster {
	public Dragon(String type, Game game) {
		this(type, "炎", 30, game);
	}
	public Dragon(String type, String weapon, int maxAp, Game game) {
		super(type, weapon, maxAp, game);
	}
	

}
