package game;

import java.util.Scanner;

/**
 * mapをインスタンスフィールドにしているので、
 * アクセスしてくるユーザーそれぞれに個別のマップを
 * 提供できる。
 */
public class Game {
	public static final int YSIZE = 5;
	public static final int XSIZE = 5;
	private String[][] map = {
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."},
			{".", ".", "#", "#", "."},
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."}
	}; 
	
	public Game() {}
	
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
			if (m.getHp() <= 0) { 
				map[m.getY()][m.getX()]= "."; 
				break; 
			}
			m.attack(p);
			if (p.getHp() <= 0) {
				break; 
			}
			System.out.print(p.getName() + ":" + p.getHp() + " ");
			System.out.println(m.getType() + ":" + m.getHp());
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

	public String[][] getMap() {
		return map;
	}
}
