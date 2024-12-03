package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Goblin g = new Goblin("goblin");
		Dragon d = new Dragon("dragon");
		Potion po = new Potion("potion");
		Player p = new Player("太郎");
		p.look();

		outHere:
		while (true) {
			if (p.getHp() <= 0) {
				System.out.println(p.getName() + "は、倒れてしまった。");
				break; 
			}
			System.out.print("wens:移動 q:終了 > ");
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			switch (s) {
				case "q" -> { break outHere; }
				case "w","e","n","s" -> {
					p.move(s); 
					p.look(); 
				}
				case "p" -> { Game.printMap(); }
			}
			String thing = Game.map[p.getY()][p.getX()];
			switch (thing) {
			case "goblin" -> { Game.buttle(p, g); }
			case "dragon" -> { Game.buttle(p, d); }
			// case "potion" -> { p.take(po); }
			}
		}
		System.out.println("GAME OVER");

	}

}
