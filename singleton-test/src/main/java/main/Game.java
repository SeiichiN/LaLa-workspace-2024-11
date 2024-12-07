package main;

public class Game {
	private static Game game = new Game();
	private String name = "名無し";
	
	private Game() {}
	
	public static Game getInstance() {
		return game;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
