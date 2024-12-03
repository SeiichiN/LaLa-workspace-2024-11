package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		Scanner scan = new Scanner(System.in);
		Goblin g = new Goblin("goblin");
		g.setLocation(game);
		g.setSelfOnMap(game);
		
		Dragon d = new Dragon("dragon");
		d.setLocation(game);
		d.setSelfOnMap(game);
		
		Potion po = new Potion("potion");
		po.setLocation(game);
		po.setSelfOnMap(game);
		
		Player p = new Player("太郎");
		p.setLocation(game);
		p.look(game);

		// game.printMap();  // mapを表示
		
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
			case "w","e","n","s" -> { p.move(dir, game); }
			case "t" -> { p.status(); }
			case "u" -> { p.use(); }
			case "p" -> { game.printMap(); }
			}
			switch (game.map[p.getY()][p.getX()]) {
			case "goblin" -> {
				game.buttle(p, g);
			}
			case "dragon" -> {
				game.buttle(p, d);
			}
			case "potion" -> {
				p.take(po, game);
			}
			}
		}
		System.out.println("終了します。");
	}

}
