package rpg;

public class Wizard {
	private int hp;
	private int mp;
	private String name;
	private Wand wand;
	
	public Wizard() {
		Wand wand = new Wand("魔法の杖");
		setWand(wand);
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
		if (hp < 0) { hp = 0; }
		this.hp = hp;
	}
	public int getMp() {
		return this.mp;
	}
	public void setMp(int mp) {
		if (mp < 0) {
			throw new IllegalArgumentException("魔力がマイナスで、不正です。");
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
	
	public String toString() {
		return this.name + "HP:" + this.hp + " MP:" + this.mp + " 装備:" + this.wand.getName();
	}
}