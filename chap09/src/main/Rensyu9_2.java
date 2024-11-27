package main;

public class Rensyu9_2 {
	public static void heal(int hp) {
		hp += 10;  // 35
		System.out.println("1:" + hp);
	}
	public static void heal(Thief thief) {
		thief.hp += 10;
	}
	
	public static void main(String[] args) {
		int baseHp = 25;
		Thief t = new Thief("アサカ", baseHp);
		heal(baseHp);
		System.out.println(baseHp + " : " + t.hp);  // 25:25
		heal(t);
		System.out.println(baseHp + " : " + t.hp);  // 25:35
	}

}
