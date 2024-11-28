package main;

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
}
