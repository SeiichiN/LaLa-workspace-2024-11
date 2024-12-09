package game;

public class Potion extends Item {
	private int rp = 100;
	public Potion(String type, Game game) {
		super(type, game);
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
}
