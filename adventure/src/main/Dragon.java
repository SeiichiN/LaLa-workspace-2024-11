package main;

public class Dragon extends Monster {
	public Dragon(String type) {
		super(type);
	}

	@Override
	public void attack(Player p) {
		System.out.println(this.getType() + "は口から火を噴いた。");
		super.attack(p);
	}

}
