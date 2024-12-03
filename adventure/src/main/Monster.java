package main;

public abstract class Monster extends GameLocation 
                              implements SetSelfOnMap {
	private String type;
	private int hp;
	private final int MAXAP = 20;
	
	public Monster(String type) {
		this.type = type;
		this.hp = 100;
	}
	
	@Override
	public void setSelfOnMap(Game g) {
		g.map[this.getY()][this.getX()] = this.type;
	}
	
	public	void attack(Player p) {
		if (this.hp <= 0) { return; }
		System.out.println(this.type + "の攻撃！");
		int ap = (int)Math.floor(Math.random() * MAXAP);
		p.setHp(p.getHp() - ap);
		if (p.getHp() > 0) {
			System.out.println(p.getName() + "に対して" + ap + "のダメージを与えた！");
		} else {
			System.out.println(p.getName() + "を倒した！");
		}
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
}
