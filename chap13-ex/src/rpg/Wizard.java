package rpg;

public class Wizard {
	private int hp;
	private int mp;
	private String name;
	private Wand wand;

	public Wizard(String name, Wand wand) {
		this.setName(name);
		this.setWand(wand);
	}
	
	public String toString() {
		return name + " HP:" + hp + " MP:" +
	            mp + " 装備:" + wand;
	}

	public void heal(Hero h) {
		int basePoint = 10;
		int recovPoint = (int) (basePoint * this.wand.getPower());
		h.setHp(h.getHp() + recovPoint);
		System.out.println(h.getName() + "のHPを" + recovPoint + "回復した。");
	}

	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		if (hp < 0) {
			hp = 0;
		}
		this.hp = hp;
	}
	public int getMp() {
		return this.mp;
	}
	public void setMp(int mp) {
		if (mp < 0) {
			throw new IllegalArgumentException("MPは0以上が必要です。");
		}
		this.mp = mp;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if (name.length() < 3) {
			throw new IllegalArgumentException("名前が短すぎます。");
		}
		this.name = name;
	}
	public Wand getWand() {
		return this.wand;
	}
	public void setWand(Wand wand) {
		this.wand = wand;
	}
	
	
}
