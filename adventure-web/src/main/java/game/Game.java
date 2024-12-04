package game;

import java.util.Scanner;

public class Game {
	private static Game game;
	public static final int YSIZE = 5;
	public static final int XSIZE = 5;
	private String[][] map = {
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."},
			{".", ".", "#", "#", "."},
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."}
	}; 
	
	private Game() {
		game = new Game();
	}
	
	public static Game getInstance() {
		if (game != null) { return game; }
		else { 
			game =  new Game();
			return game;
		}
	}
	
	public void printMap() {
		for (int y = 0; y < YSIZE; y++) {
			System.out.print("| ");
			for (int x = 0; x < XSIZE; x++) {
				System.out.print(map[y][x].charAt(0) + " | ");
			}
			System.out.println();
		}
	}
	
	public String getCharacter(int y, int x) {
		return map[y][x];
	}
	
	public void buttle(Player p, Monster m) {
		Scanner scan = new Scanner(System.in);
		String select = null;
		while (true) {
			System.out.print("a:攻撃する q:逃げる > ");
			select = scan.nextLine().trim().toLowerCase();
			if (select.equals("q")) { return; }
			p.attack(m);
			if (m.hp <= 0) { 
				map[m.y][m.x]= "."; 
				break; 
			}
			m.attack(p);
			if (p.hp <= 0) {
				break; 
			}
			System.out.print(p.name + ":" + p.hp + " ");
			System.out.println(m.type + ":" + m.hp);
		}
	}
	
	public static String openning() {
		Scanner scan = new Scanner(System.in);
		String gamen = 
				"""
				+---------------------------+
				|   Adventure Game          |
				|                           |
				|  作者: Seiichi Nukayama   |
				+---------------------------+
				""";
		System.out.println(gamen);
		System.out.print("プレーヤーの名前を決めてください > ");
		String name = scan.nextLine();
		return name;
	}
}
