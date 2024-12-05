package ex2;

import java.util.Random;

public class Cleric {
	String name;
	int hp = 50;
	static final int MAXHP = 50;
	int mp = 10;
	static final int MAXMP = 10;
	
	public void selfAid() {
		this.mp -= 5;
		this.hp = this.MAXHP;
		System.out.println(this.name + "は、セルフエイドという魔法を使った。");
		System.out.println("自分のHPを最大にした。");
		System.out.println("自分のMPを5使った。");
	}
	
	public int pray(int sec) {
		int beforeMp = this.mp;
		int hosei = new Random().nextInt(3);
		int recovery = sec + hosei;
		this.mp = this.mp + recovery;
		if (this.mp > this.MAXMP) {
			this.mp = this.MAXMP;
		}
		recovery = this.mp - beforeMp;
		return recovery;
	}
}
