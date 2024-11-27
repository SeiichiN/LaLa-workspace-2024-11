package main;

public class Main {

	public static void main(String[] args) {
		Hero h1 = new Hero("ミナト");
		Hero h2 = new Hero("アサカ");
		Wizard w = new Wizard("メグミン");
		Hero h3 = new Hero();
		w.heal(h1);
		w.heal(h2);
		w.heal(h2);
		w.heal(h3);
		Sword s = new Sword();
		s.name = "炎の剣";
		s.damage = 50;
	}

}
