package main;

import rpg.Hero;
import rpg.Wizard;

public class Main {

	public static void main(String[] args) {
		Hero h = new Hero();
		Wizard w = new Wizard();
		w.heal(h);

	}

}
