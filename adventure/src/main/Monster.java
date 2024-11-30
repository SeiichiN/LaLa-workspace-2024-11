package main;

public abstract class Monster extends GameLocation 
                              implements SetSelfOnMap {
	String type;
	int hp;
	final int MAXAP = 20;
	
	public Monster(String type) {
		this.type = type;
		this.hp = 100;
	}
	
	@Override
	public void setSelfOnMap(Game g) {
		g.map[this.y][this.x] = this.type;
	}
	
	public	void attack(Player p) {
		if (this.hp <= 0) { return; }
		System.out.println(this.type + "の攻撃！");
		int ap = (int)Math.floor(Math.random() * MAXAP);
		p.hp -= ap;
		if (p.hp > 0) {
			System.out.println(p.name + "に対して" + ap + "のダメージを与えた！");
		} else {
			System.out.println(p.name + "を倒した！");
		}
	}
}
