package main6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String s = "";
		do {
			System.out.println("名前を入力してください");
			s = new Scanner(System.in).nextLine();
		} while (!isValidPlayerName(s));
		System.out.println("正しい名前です");
		

	}
	
	public static boolean isValidPlayerName(String name) {
		return name.matches("[A-Z][A-Z0-9]{7}");
	}

}
