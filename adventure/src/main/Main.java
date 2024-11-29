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
		p.printNowPlace();

		// game.printMap();  // mapを表示
		
		outLoop:
		while (true) {
			System.out.print("wens:移動 q:終了 > ");
			String dir = scan.nextLine();
			switch (dir) {
			case "q" -> { break outLoop; }
			case "w","e","n","s" -> { p.move(dir, game); }
			}
		}
		System.out.println("終了します。");
	}

}
