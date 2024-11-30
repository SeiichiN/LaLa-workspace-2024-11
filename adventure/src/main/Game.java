package main;

import java.util.Scanner;

public class Game {
	final int YSIZE = 5;
	final int XSIZE = 5;
	String[][] map = {
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
			if (m.hp <= 0) { 
				this.map[m.y][m.x]= "."; 
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
}
