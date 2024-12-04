package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Game.printOpening();
		String playerName = Game.getPlayerName();
		
		Goblin g = new Goblin("goblin", "斧", 11);
		g.setAttackText(g.getType() + "は" + g.getWeapon() + "で斬りつけた！");
		Dragon d = new Dragon("dragon", "炎", 33);
		d.setAttackText(d.getType() + "は口から" + d.getWeapon() + "を噴き出した！");
		Potion po = new Potion("potion");
		Player p = new Player(playerName);
		p.look();

		outHere:
		while (true) {
			if (p.getHp() <= 0) {
				System.out.println(p.getName() + "は、倒れてしまった。");
				break; 
			}
			System.out.print("WENS:移動 L:見る T:装備 Q:終了 > ");
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			switch (s) {
				case "q" -> { break outHere; }
				case "w","e","n","s" -> {
					p.move(s); 
					p.look(); 
				}
				case "l" -> { p.look(); }
				case "t" -> { p.status(); }
				case "p" -> { Game.printMap(p); }
			}
			String thing = Game.map[p.getY()][p.getX()];
			switch (thing) {
			case "goblin" -> { Game.buttle(p, g); }
			case "dragon" -> { Game.buttle(p, d); }
			case "potion" -> { p.take(po); }
			}
		}
		System.out.println("GAME OVER");
	}

}
