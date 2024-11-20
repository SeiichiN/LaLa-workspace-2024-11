package ex4;

public class Main {

	public static void main(String[] args) {
		int[] numbers = new int[] {3, 4, 9};
		out:
		while (true) {
			System.out.println("1桁の数字を入力してください");
			int input = new java.util.Scanner(System.in).nextInt();
			for (int n : numbers) {
				if (input == n) {
					System.out.println("あたり");
					break out;
				}
			}
		}
		System.out.println("終了");
	}

}
