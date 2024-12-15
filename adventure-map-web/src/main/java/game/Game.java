package game;

import java.util.Scanner;

public class Game {
	public final int YSIZE;
	public final int XSIZE;
	public final int REWARD;
	public final int AMOUNT;
	private SetOnMap[][] map;
	private int mission;
	
	public Game(int ysize, int xsize, int reward, int amount, int mission) {
		this.YSIZE = ysize;
		this.XSIZE = xsize;
		this.REWARD = reward;
		this.AMOUNT = amount;
		this.mission = mission;
		this.map = new SetOnMap[ysize][xsize];
	}
	
	public Game() {
		this(5, 5, 50, 200, 1);
	}
	
	public static void opening() {
		// p.68 テキストブロック
		String str = 
				"""
				+----------------------+
				| Adventure Game       |
				|                      |
				|  by Seiichi Nukayama |
				+----------------------+
				""";
		System.out.println(str);
	}
	
	public void printMap() {
		for (int y = 0; y < YSIZE; y++) {
			System.out.print("| ");
			for (int x = 0; x < XSIZE; x++) {
				System.out.print(map[y][x].toString().charAt(0) + " | ");
			}
			System.out.println();
		}
	}
	
	public void printMap(Player p) {
		char c = ' ';
		for (int y = 0; y < YSIZE; y++) {
			System.out.print("| ");
			for (int x = 0; x < XSIZE; x++) {
				if (p.getY() == y && p.getX() == x) {
					c = '*';
				} else {
					if (this.map[y][x] == null) {
						c = '.';
					} else {
						String s = map[y][x].toString();
						c = s.charAt(0);
					}
				}
				System.out.print(c + " | ");
			}
			System.out.println();
		}
	}
	
	public static void printOpening() {
		String opening = 
				"""
				+-------------------------+
				|  Adventure Game         |
				|                         |
				|     by Seiichi Nukayama |
				+-------------------------+
				""";
		System.out.println(opening);
	}
	
	public static String getPlayerName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("プレーヤーの名前を決めてください > ");
		String name = scan.nextLine();
		return name;
	}
	
	public static void buttle(Player p, Monster m) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			if (p.getHp() <= 0 || m.getHp() <= 0) { break; }
			System.out.print("A:戦う R:逃げる > ");
			String s = scan.nextLine();
			switch (s) {
				case "r" -> { return; }
				case "a" -> {
					p.attack(m);
					m.attack(p);
					System.out.print(p.getName() + " HP:" + p.getHp() + "  ");
					System.out.println(m.getType() + " HP:" + m.getHp());
				}
			}
		}
//		if (m.getHp() <= 0) {
//			map[m.getY()][m.getX()] = ".";
//			p.setGolds(Game.REWARD);
// 		}
	}

	public SetOnMap[][] getMap() {
		return map;
	}

	public int getAMOUNT() {
		return AMOUNT;
	}

	public int getMission() {
		return mission;
	}

	public void setMission(int mission) {
		this.mission = mission;
	}

	public int getYSIZE() {
		return YSIZE;
	}

	public int getXSIZE() {
		return XSIZE;
	}

	public int getREWARD() {
		return REWARD;
	}

}
