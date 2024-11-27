package main;

public class Matango {
	char suffix = 'A';
	int hp = 50;
	
	public void attack(SuperHero h) {
		System.out.println(this.suffix + "の攻撃！");
		h.hp -= 5;
		System.out.println("5ポイントのダメージを与えた。");
	}
	
	public void run() {
		System.out.println(this.suffix + "は逃げ出した！");
	}
}
