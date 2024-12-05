package _static;

public class Main {

	public static void main(String[] args) {
		Hero.setRandomMoney();
		System.out.println(Hero.money);

		Hero h1 = new Hero();
		h1.name = "ミナト";
		h1.hp = 100;
		
		Hero h2 = new Hero();
		h2.name = "アサカ";
		h2.hp = 120;
		// Hero.money = 2000;
		
		Hero h3 = new Hero();
		h3.name = "スガワラ";
		h3.hp = 140;
		// Hero.money = 3000;

		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
		
	}

}
