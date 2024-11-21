package main;

public class Main {

	public static void main(String[] args) {
		while(true) {
			janken();
		}
	}
	
	public static void janken() {
		String[] hand = {"グー", "チョキ", "パー"};
		int com = new java.util.Random().nextInt(3);
		System.out.print("0:グー 1:チョキ 2:パー > ");
		int user = new java.util.Scanner(System.in).nextInt();
		String result = "";
		if (user == com) {
			result = "あいこ";
		} else if ((user + 1) % 3 == com) {
			result = "ユーザーの勝ち";
		} else {
			result = "わたしの勝ち";
		}
		System.out.println("わたし:" + hand[com]);
		System.out.println("ユーザー:" + hand[user]);
		System.out.println(result);
	}
}
