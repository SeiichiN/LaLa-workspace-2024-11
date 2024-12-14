package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Game.printOpening();
		String playerName = Game.getPlayerName();
		Game game = new Game();
		
		new NotEnter(game);
		new NotEnter(game);
		
		Goblin g = new Goblin("goblin", "斧", 11, game);
		Dragon d = new Dragon("dragon", "炎", 33, game);
		Potion po = new Potion("potion", game);
		Ether e = new Ether("ether", game);
		Player p = new Player(playerName, game);
		p.look();
		Gold[] golds = new Gold[5];
		for (int i = 0; i < golds.length; i++) {
			golds[i] = new Gold("Gold", game);
		}

		outHere:
		while (true) {
			if (p.getGold() == Game.AMOUNT) {
				System.out.println("Goldが" + p.getGold() + "になった。目的は達成した。");
				break;
			}
			if (p.getHp() <= 0) {
				System.out.println(p.getName() + "は、倒れてしまった。");
				break; 
			}
			System.out.print("WENS:移動 L:見る I:装備 U:使う Q:終了 > ");
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			switch (s) {
				case "q" -> { break outHere; }
				case "w","e","n","s" -> {
					p.move(s); 
					p.look(); 
				}
				case "l" -> { p.look(); }
				case "u" -> { p.use(); }
				case "i" -> { p.status(); }
				case "p" -> { game.printMap(p); }
			}
			SetOnMap[][] soMap = game.getMap();
			String thing = null;
			if (soMap[p.getY()][p.getX()] == null) {
				thing = ".";
			} else {
				thing = soMap[p.getY()][p.getX()].getType();
			}
			switch (thing) {
			case "goblin" -> { Game.buttle(p, g); }
			case "dragon" -> { Game.buttle(p, d); }
			case "potion" -> { p.take(po); }
			case "ether" -> { p.take(e); }
			case "Gold" -> {
				Gold gold = pickupGold(golds, p);
				p.take(gold); 
				}
			}
		}
		System.out.println("GAME OVER");
	}
	
	public static Gold pickupGold(Gold[] golds, Player p) {
		Gold gold = null;
		for (Gold g : golds) {
			if (g.getY() == p.getY() && g.getX() == p.getX()) {
				gold = g;
			}
		}
		return gold;
	}

}
