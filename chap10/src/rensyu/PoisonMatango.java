package rensyu;

public class PoisonMatango extends Matango {
	int attackCount = 5;
	int count = 0;
	
	public PoisonMatango(char suffix) {
		super(suffix);
	}
	
	@Override
	public void attack(Hero h) {
		count++;
		System.out.println(count + "回目の攻撃 ---------------");
		super.attack(h);
		if (this.attackCount > 0) {
			System.out.println("さらに毒の胞子をばらまいた！");
			int damage = h.hp / 5;
			h.hp = h.hp - damage;
			System.out.println(damage + "ポイントのダメージ!");
			this.attackCount--;
		}
	}
}
