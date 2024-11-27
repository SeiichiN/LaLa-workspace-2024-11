package main;

public class Wizard {
	String name;
	int hp;
	
	public Wizard(String name) {
		this.name = name;
		this.hp = 50;
	}
	
	public void heal(Hero h) {
		h.hp += 10;
		System.out.print(this.name + "は" + h.name + "のHPを10回復した。");
		System.out.println(" -> " + h.hp);
	}
}
