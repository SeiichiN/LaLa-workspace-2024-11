package main;

import java.util.Scanner;

public class Game {
	public static final int YSIZE = 5;
	public static final int XSIZE = 5;
	public static String[][] map = {
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."},
			{".", ".", "#", "#", "."},
			{".", ".", ".", ".", "."},
			{".", ".", ".", ".", "."}
	}; 
	
	public void printMap() {
		for (int y = 0; y < YSIZE; y++) {
			System.out.print("| ");
			for (int x = 0; x < XSIZE; x++) {
				System.out.print(map[y][x].charAt(0) + " | ");
			}
			System.out.println();
		}
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
				this.map[m.getY()][m.getX()]= "."; 
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
}
