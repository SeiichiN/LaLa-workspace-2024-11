package main;

public class Main {

	public static void main(String[] args) {
		Matango m = new Matango('A');
		Dancer d = new Dancer();
		d.name = "ゆかり";
		d.hp = 80;
		d.attack(m);
		m.attack(d);

	}

}
