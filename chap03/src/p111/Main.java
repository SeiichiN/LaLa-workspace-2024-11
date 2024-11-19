package p111;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("> ");
		String sss = "sukkiri";
		String str = new Scanner(System.in).nextLine();
		if (str == sss) {
			System.out.println("同じ");
		} else {
			System.out.println("ちがう");
		}

	}

}
