package main.java;

public abstract class Monster extends SetOnMap {
	private int hp;
	private String attackText;
	private int maxAp;
	private int gold;
	
	public Monster(String type, Game game) {
		this(type, "頭突き", 30, 50, game);
	}
	
	public Monster(String type, String attackText, int maxAp, int gold, Game game) {
		super(type, game);
		this.hp = 100;
		this.attackText = attackText;
		this.maxAp = maxAp;
		this.gold = gold;
	}
		
	public void attack(Player p) {
		if (this.getHp() <= 0) { return; }		
		System.out.println(this.getType() + "は" + attackText);
		int ap = (int)Math.floor(Math.random() * (this.getMaxAp() + 1));
		if (ap == 0) {
			System.out.println(this.getType() + "の攻撃失敗。");
		} else {
			p.setHp(p.getHp() - ap);
			System.out.println(p.getName() + "に" + ap + "ポイントのダメージ");
		}
		if (p.getHp() <= 0) {
			System.out.println(p.getName() + "を倒した。");
		}
	}
	
	public int getMaxAp() { return this.maxAp; }
	public void setMaxAp(int maxAp) { this.maxAp = maxAp; }
	public int getHp() { return this.hp; }
	public void setHp(int hp) {	this.hp = hp; }

	public String getAttackText() {
		return attackText;
	}

	public void setAttackText(String attackText) {
		this.attackText = attackText;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
}
