package main;

import java.util.Random;
import java.util.Scanner;

public class Main {
	final static int YSIZE = 5;
	final static int XSIZE = 5;
	static String[][] map = { { ".", ".", ".", ".", "." }, { ".", ".", ".", ".", "." }, { ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", "." }, { ".", ".", ".", ".", "." }, };
	static Random rnd = new Random();

	public static void main(String[] args) {
		setCharacter("gold");
		setCharacter("goblin");
		setCharacter("dragon");
		setCharacter("potion");
		printMap();
		int y = rnd.nextInt(YSIZE);
		int x = rnd.nextInt(XSIZE);
		int[] pos = {y, x};
		System.out.println("[" + y + ":" + x + "] " + map[y][x]);
		do {
			move(pos);
			y = pos[0];
			x = pos[1];
			System.out.println("[" + y + ":" + x + "] " + map[y][x]);
		} while (true);
	}

	public static void move(int[] pos) {
		int y = pos[0];
		int x = pos[1];
		System.out.print("wens q:end > ");
		String d = new Scanner(System.in).nextLine();
		switch (d) {
		case "w" -> {
			x -= 1;
			x = (x < 0) ? 0 : x;
		}
		case "e" -> {
			x += 1;
			x = (x >= XSIZE) ? XSIZE - 1 : x;
		}
		case "n" -> {
			y -= 1;
			y = (y < 0) ? 0 : y;
		}
		case "s" -> {
			y += 1;
			y = (y >= YSIZE) ? y = YSIZE - 1 : y;
		}
		case "q" -> {
			gameover();
		}
		}
		pos[0] = y;
		pos[1] = x;
	}

	public static void setCharacter(String ch) {
		int row = 0;
		int col = 0;
		do {
			row = rnd.nextInt(YSIZE);
			col = rnd.nextInt(XSIZE);
		} while (map[row][col] != ".");
		map[row][col] = ch;
	}

	public static void printMap() {
		for (int y = 0; y < YSIZE; y++) {
			for (int x = 0; x < XSIZE; x++) {
				System.out.print("|" + map[y][x]);
			}
			System.out.println("|");
		}
	}
	
	public static void gameover() {
		System.out.println("終了します");
		System.exit(0);
	}
}
