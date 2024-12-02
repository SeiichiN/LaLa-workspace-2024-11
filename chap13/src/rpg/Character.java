package rpg;

import monster.Matango;

public abstract class Character {
	private String name;
	private int hp;
	
	public void run() {
		System.out.println(this.name + "は逃げ出した。");
	}
	public abstract void attack(Matango m);
}
