package test;

import java.util.Scanner;

import game.Dragon;
import game.Ether;
import game.Game;
import game.Goblin;
import game.Gold;
import game.NotEnter;
import game.Player;
import game.Potion;
import game.SetOnMap;

public class Main {
	
	/**
	 * YSIZE
	 * XSIZE
	 * REWARD -- モンスターを１つ倒した時の報酬
	 * AMOUNT -- gold がどれだけたまったらゴールとするか
	 * @return
	 */
	private static Game startGame() {
		Game game = new Game(10, 10, 50, 300, 1);
		
		new NotEnter(game);
		new NotEnter(game);
		new NotEnter(game);
		new NotEnter(game);
		
		new Goblin("goblin", "斧で斬りつけた", 21, game);
		new Goblin("goblin", "棍棒で殴りかかった", 11, game);
		new Dragon("dragon", "口から炎を噴き出した", 33, game);
		new Dragon("dragon", "大きな口で噛みついた", 33, game);
		new Potion("potion", game);
		new Potion("potion", game);
		new Potion("potion", game);
		new Ether("ether", game);
		new Ether("ether", game);
		for (int i = 0; i < 5; i++) {
			new Gold("Gold", game);
		}
		return game;
	}

	public static void main(String[] args) {
		Game.printOpening();
		String playerName = Game.getPlayerName();
		Game game = startGame();
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
		System.out.println("GAME OVER");
	}
	
}
