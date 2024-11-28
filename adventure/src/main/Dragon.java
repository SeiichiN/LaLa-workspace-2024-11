package main;

public class Dragon extends Monster {
	public Dragon(String type) {
		super(type);
	}

	@Override
	public void attack(Player p) {
		System.out.println(this.type + "は口から火を噴いた。");
		p.hp -= 30;
		System.out.println(p.name + "に30ポイントのダメージ");
		
	}
}
