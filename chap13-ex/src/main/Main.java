package main;

import rpg.Hero;
import rpg.Wizard;

public class Main {

	public static void main(String[] args) {
		Hero h = new Hero();
		Wizard w = new Wizard();
		try {
			w.setName("アカ");
			w.setHp(20);
			w.setMp(10);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(w);
		w.heal(h);

	}

}
