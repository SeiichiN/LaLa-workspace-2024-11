package main;

import rpg.Hero;
import rpg.Wand;
import rpg.Wizard;

public class Main {

	public static void main(String[] args) {
		Hero h = new Hero();
		Wand wn = new Wand();
		wn.setName("魔法の杖");
		wn.setPower(100);
		
		Wizard w = new Wizard("アサカ",wn);

		w.setHp(100);
		w.setMp(10);

		System.out.println(w);

		w.heal(h);

	}

}
