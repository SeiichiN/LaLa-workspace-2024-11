package main.java;

import java.util.Scanner;

public class Main {
	
	/**
	 * YSIZE
	 * XSIZE
	 * REWARD -- モンスターを１つ倒した時の報酬
	 * AMOUNT -- gold がどれだけたまったらゴールとするか
	 * @return
	 */
	private static Game startGame(int stage) {
		Game game = null;
		switch (stage) {
			case 1 -> {
				game = new Game(5, 5, 180, 1);
			}
			case 2 -> {
				game = new Game(7, 7, 360, 2);
			}
		}

		if (stage >= 1) {
			new NotEnter(game);
			new NotEnter(game);
			new Goblin("goblin", "斧で斬りつけた", 20, 30, game);
			new Dragon("dragon", "口から炎を噴き出した", 30, 50, game);
			new Potion("potion", game);
			new Ether("ether", game);
			for (int i = 0; i < 5; i++) {
				new Gold("Gold", game);
			}
		}
		if (stage >= 2) {
			new NotEnter(game);
			new NotEnter(game);
			
			new Goblin("goblin", "棍棒で殴りかかった", 10, 30, game);
			new Dragon("dragon", "大きな口で噛みついた", 30, 50, game);
			new Potion("potion", game);
			new Potion("potion", game);
			new Ether("ether", game);
			for (int i = 0; i < 5; i++) {
				new Gold("Gold", game);
			}
		}
		return game;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Game.printOpening();
		String playerName = Game.getPlayerName();
		int stage = 1;
		while (true) {
			String floor = "<<< STAGE " + stage + " >>>";
			System.out.println(floor + "\n (Enter でスタート)");
			scan.nextLine();
			Game game = startGame(stage);
			Player p = new Player(playerName, game);
			p.look();

			outHere:
			while (true) {
				if (p.getGold() == game.AMOUNT) {
					System.out.println("Goldが" + p.getGold() + "になった。目的は達成した。");
					break;
				}
				if (p.getHp() <= 0) {
					System.out.println(p.getName() + "は、倒れてしまった。");
					break; 
				}
				System.out.print("WENS:移動 L:見る I:装備 U:使う Q:終了 > ");
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
				SetOnMap soMapObj = game.getMap()[p.getY()][p.getX()];
				String thing = null;
				if (soMapObj == null) {
					thing = ".";
				} else {
					thing = soMapObj.getType();
				}
				switch (thing) {
					case "goblin" -> {
						if (soMapObj instanceof Goblin goblin) {
							Game.buttle(p, goblin); 
						}
					}
					case "dragon" -> {
						if (soMapObj instanceof Dragon dragon) {
							Game.buttle(p, dragon); 
						}
					}
					case "potion" -> {
						if (soMapObj instanceof Potion potion) {
							p.take(potion); 
						}
					}
					case "ether" -> {
						if (soMapObj instanceof Ether ether) {
							p.take(ether); 
						}
					}
					case "Gold" -> {
						if (soMapObj instanceof Gold gold) {
							p.take(gold); 
						}
					}
				}
			}
			if (p.getHp() > 0) { 
				System.out.println("<<< STAGE CLEAR >>>");
				stage++;
			} else {
				System.out.print("Retry? (y/n) >");
				String key = scan.nextLine().toLowerCase();
				if (key.equals("y")) {
					p.setHp(100);
				} else {
					break;
				}
			}
			if (stage > 2) { break; }
		}
		System.out.println("GAME OVER");
	}
	
}
