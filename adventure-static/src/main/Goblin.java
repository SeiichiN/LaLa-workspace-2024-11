package main;

public class Goblin extends Monster {
	public Goblin(String type) {
		super(type);
	}

	@Override
	public void attack(Player p) {
		System.out.println(this.type + "は斧で切りつけた。");
		super.attack(p);
	}
}