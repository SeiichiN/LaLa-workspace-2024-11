package main;

public class Monster {
	int hp;
	static {
		// hp = 110;
		System.out.println("静的初期化");
	}
	{
		// hp = 120;
		System.out.println("初期化");
	}
	public Monster() {
		hp = 100;
		System.out.println("コンストラクタ");
	}
}
