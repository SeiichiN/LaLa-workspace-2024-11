package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Game.openning();
		Scanner scan = new Scanner(System.in);
		Goblin g = new Goblin("goblin");
		Dragon d = new Dragon("dragon");
		Potion po = new Potion("potion");
		Player p = new Player(Game.playerName);
		p.look();

		// game.printMap();  // mapを表示
		
		outLoop:
		while (true) {
			if (p.hp <= 0) {
				System.out.println(p.name + "は倒れた！");
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
			case "p" -> { Game.printMap(); }
			}
			switch (Game.map[p.y][p.x]) {
			case "goblin" -> {
				Game.buttle(p, g);
			}
			case "dragon" -> {
				Game.buttle(p, d);
			}
			case "potion" -> {
				p.take(po);
			}
			}
		}
		System.out.println("終了します。");
	}

}