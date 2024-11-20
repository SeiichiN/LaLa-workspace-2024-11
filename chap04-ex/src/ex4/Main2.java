package ex4;

public class Main2 {

	public static void main(String[] args) {
		int[] numbers = new int[] {3, 4, 9};

		boolean repeat = true;
		do {
			System.out.println("1桁の数字を入力してください");
			int input = new java.util.Scanner(System.in).nextInt();
			for (int n : numbers) {
				if (input == n) {
					System.out.println("あたり");
					repeat = false;
				}
			}
		} while (repeat);
		System.out.println("終了");
	}

}
