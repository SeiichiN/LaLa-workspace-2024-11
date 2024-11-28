package main;

public class Main {

	public static void main(String[] args) {
		SuperHero sh = new SuperHero();
		Matango m = new Matango();
		sh.attack(m);
		m.attack(sh);
		sh.run();
		m.run();
		sh.fly();
		sh.land();
		sh.slip();
	}

}
