package monster;

import rpg.Hero;

public class Matango {
	private int hp = 50;
	private char suffix;
	
	public Matango(char suffix) {
		this.suffix = suffix;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setSuffix(char suffix) {
		this.suffix = suffix;
	}
	
	public char getSuffix() {
		return this.suffix;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void attack(Hero h) {
		System.out.println("キノコ" + this.suffix + "の攻撃");
		System.out.println("10のダメージ");
		h.setHp(h.getHp() - 10);
	}
	

}
