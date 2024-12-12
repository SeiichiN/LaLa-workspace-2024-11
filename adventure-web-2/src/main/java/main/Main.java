package main;

import java.util.Scanner;

import game.Dragon;
import game.Game;
import game.Goblin;
import game.Player;
import game.Potion;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		String name = Game.openning();
		Scanner scan = new Scanner(System.in);
		game.setLocation("goblin");
		game.setLocation("dragon");
		game.setLocation("potion");
		game.setLocation("ether");
		game.setLocation("Gold");
		game.setLocation("#");
		game.setLocation("#");
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
				game.buttle(p, new Goblin("goblin"));
			}
			case "dragon" -> {
				game.buttle(p, new Dragon("dragon"));
			}
			case "potion" -> {
				p.take(new Potion("potion"));
			}
			case "ether" -> {
				// p.take(new Ether("ether"));
			}
			case "Gold" -> {
				// p.take(new Gold("Gold"));
			}
			}
		}
		System.out.println("終了します。");
	}

}
