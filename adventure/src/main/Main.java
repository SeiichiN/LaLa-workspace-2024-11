package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Game.printOpening();
		String playerName = Game.getPlayerName();
		
		new NotEnter();
		new NotEnter();
		
		Goblin g = new Goblin("goblin", "斧", 11);
		g.setAttackText(g.getType() + "は" + g.getWeapon() + "で斬りつけた！");
		Dragon d = new Dragon("dragon", "炎", 33);
		d.setAttackText(d.getType() + "は口から" + d.getWeapon() + "を噴き出した！");
		Potion po = new Potion("potion");
		Player p = new Player(playerName);
		p.look();
		Gold[] golds = new Gold[5];
		for (int i = 0; i < golds.length; i++) {
			golds[i] = new Gold("Gold");
		}

		outHere:
		while (true) {
			if (p.getGolds() == Game.AMOUNT) {
				System.out.println("Goldが" + p.getGolds() + "になった。目的は達成した。");
				break;
			}
			if (p.getHp() <= 0) {
				System.out.println(p.getName() + "は、倒れてしまった。");
				break; 
			}
			System.out.print("WENS:移動 L:見る I:装備 Q:終了 > ");
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			switch (s) {
				case "q" -> { break outHere; }
				case "w","e","n","s" -> {
					p.move(s); 
					p.look(); 
				}
				case "l" -> { p.look(); }
				case "i" -> { p.status(); }
				case "p" -> { Game.printMap(p); }
			}
			String thing = Game.map[p.getY()][p.getX()];
			switch (thing) {
			case "goblin" -> { Game.buttle(p, g); }
			case "dragon" -> { Game.buttle(p, d); }
			case "potion" -> { p.take(po); }
			case "Gold" -> { p.take(golds); }
			}
		}
		System.out.println("GAME OVER");
	}

}
