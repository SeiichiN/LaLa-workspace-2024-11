package main;

import java.util.Scanner;

public class Quest {
	private final int MINUS = -10;
	private final int DRAW = 0;
	private final int PLUS = 10;
	
	public int work() {
		System.out.print("1 2 3 --> select >");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int com = (int)(Math.random() * 3) + 1;  // 1,2,3
		if (num == com) {
			return DRAW;
		} else if ((num + 1) % 3 == com) {
			return PLUS;
		} else {
			return MINUS;
		}
	}
}
