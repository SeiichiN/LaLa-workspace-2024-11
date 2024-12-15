package main;

public class Gold extends SetOnMap {
	private int gold; 
	
	public Gold(String type, Game game) {
		this(type, 20, game);
	}
	
	public Gold(String type, int gold, Game game) {
		super(type, game);
		this.gold = gold;
	}

	public int getGold() {
		return this.gold;
	}
	public void setGold(int coins) {
		this.gold = coins;
	}
}
