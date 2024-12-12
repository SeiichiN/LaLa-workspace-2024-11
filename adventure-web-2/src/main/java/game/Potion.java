package game;

public class Potion extends Item {
	private int rp = 100;
	public Potion(String type) {
		super(type);
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
}
