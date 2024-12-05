package main;

import java.util.Scanner;

import game.Dragon;
import game.Game;
import game.Goblin;
import game.Player;
import game.Potion;

public class Main {

	public static void main(String[] args) {
		Game game = Game.getInstance();
		String name = Game.openning();
		Scanner scan = new Scanner(System.in);
		Goblin g = new Goblin("goblin", game);
		Dragon d = new Dragon("dragon", game);
		Potion po = new Potion("potion", game);
		Player p = new Player(name, game);
		p.look();

		outLoop:
		while (true) {
			if (p.getHp() <= 0) {
				System.out.println(p.getName() + "は倒れた！");
				System.out.println("GAME OVER");
				break; 
			}
			System.out.print("wens:移動 u:使う t:現状 q:終了 > ");
			String dir = scan.nextLine();
			switch (dir) {
			case "q" -> { break outLoop; }
			case "w","e","n","s" -> { p.move(dir); }
			case "t" -> { p.status(); }
			case "u" -> { p.use(); }
			case "p" -> { game.printMap(); }
			}
			switch (game.getMap()[p.getY()][p.getX()]) {
			case "goblin" -> {
				game.buttle(p, g);
			}
			case "dragon" -> {
				game.buttle(p, d);
			}
			case "potion" -> {
				p.take(po);
			}
			}
		}
		System.out.println("終了します。");
	}

}
