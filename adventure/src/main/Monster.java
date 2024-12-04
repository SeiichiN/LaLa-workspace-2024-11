package main;

public abstract class Monster extends GameLocation 
                              implements SetSelfOnMap {
	private String type;
	private int hp;
	private String weapon;
	private int maxAp;
	private String attackText;
	
	public Monster(String type) {
		this(type, "", 0);
	}
	public Monster(String type, String weapon, int maxAp) {
		this.type = type;
		this.hp = 100;
		this.weapon = weapon;
		this.maxAp = maxAp;
		this.attackText = this.type + "の" + this.weapon + "による攻撃!";
		setLocation();
		setSelfOnMap();
	}
	public void setSelfOnMap() {
		Game.map[this.getY()][this.getX()] = this.type;
	}
		
	public void attack(Player p) {
		if (this.getHp() <= 0) { return; }		
		System.out.println(getAttackText());
		int ap = (int)Math.floor(Math.random() * this.getMaxAp());
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
	
	public String getAttackText() { return this.attackText; }
	public void setAttackText(String text) { this.attackText = text; }
	public int getMaxAp() { return this.maxAp; }
	public void setMaxAp(int maxAp) { this.maxAp = maxAp; }
	public String getWeapon() {	return this.weapon;	}
	public void setWeapon(String weapon) { this.weapon = weapon; }
	public String getType() { return this.type;	}
	public int getHp() { return this.hp; }
	public void setHp(int hp) {	this.hp = hp; }
}
