package main;

public class Gold extends Item {
	private int gold; 
	
	public Gold(String type) {
		super(type);
		this.gold = 20;
	}

	public int getGold() {
		return this.gold;
	}
	public void setGold(int coins) {
		this.gold = coins;
	}
}
