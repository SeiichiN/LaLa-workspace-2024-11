package main;

// p450
public class Main2 {

	public static void main(String[] args) {
		Character c = new Wizard();
		if (c instanceof Wizard) {
			Wizard w = (Wizard) c;
		}
		Character c2 = new Hero();
		if (c2 instanceof Hero) {
			Hero h = (Hero) c2;
		}
		
		
	}

}
