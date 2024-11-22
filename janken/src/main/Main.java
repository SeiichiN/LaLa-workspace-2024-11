package main;

public class Main {

	public static void main(String[] args) {
		while (true) {
			int num = janken();
			if (num == 9) {
				break;
			}
		} 
		System.out.println("終了します");
	}
	
	public static int janken() {
		String[] hand = {"グー", "チョキ", "パー"};
		int com = new java.util.Random().nextInt(3);
		System.out.print("0:グー 1:チョキ 2:パー 9:終了 > ");
		int user = new java.util.Scanner(System.in).nextInt();
		if (user == 9) { return 9; }
		String result = "";
		if (user == com) {
			result = "あいこ";
		} else if ((user + 1) % 3 == com) {
			result = "ユーザーの勝ち";
		} else {
			result = "わたしの勝ち";
		}
		System.out.print("わたし:" + hand[com]);
		System.out.println(" ユーザー:" + hand[user]);
		System.out.println(result);
		return 0;
	}
}
