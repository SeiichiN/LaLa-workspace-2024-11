package rpg;

import monster.Matango;

public class Hero {
	private String name;
	private int hp;
	private Sword sword;
	
	public Hero() {
		setSword(new Sword());
	}
	
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException
			  ("名前がnullである。処理を中断。");
		}
		if (name.length() <= 1) {
			throw new IllegalArgumentException
			  ("名前が短すぎる。処理を中断。");
		}
		if (name.length() >= 8) {
			throw new IllegalArgumentException
			  ("名前が長すぎる。処理を中断。");
		}
		this.name = name;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setSword(Sword sword) {
		this.sword = sword;
	}
	
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public Sword getSword() {
		return this.sword;
	}
	
	private void die() {
		System.out.println(this.name + "は死んでしまった。");
		System.out.println("GAME OVERです。");
	}
	
	public void attack(Matango m) {
		System.out.println(this.name + "の攻撃！");
		m.setHp(m.getHp() - 5);
		System.out.println("5ポイントのダメージを与えた。");
		System.out.println("おばけキノコ" + m.getSuffix() + 
				"から2ポイントの反撃を受けた。");
		this.hp -= 2;
		if (this.hp <= 0) {
			this.die();
		}
	}
	
	void sleep() {
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した。");
	}
	
	public final void slip() {
		this.hp -= 5;
		System.out.println(this.name + "は転んだ");
		System.out.println("5のダメージ");
	}
	
	public void run() {
		System.out.println(this.name + "は逃げ出した！");
	}
}  // Hero end

class Sword {
	private String name;
	private int damage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}

}

