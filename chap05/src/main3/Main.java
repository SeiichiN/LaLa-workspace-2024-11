package main3;

public class Main {
	public static void main(String[] args) {
		int x = 100;
		int y = 20;

		if (add(x, y) == 120) {
			System.out.println(x + "+" + y + "= 120");
		}

	}

	private static int add(int x, int y) {
		int ans = x + y;
		return ans;
	}

}
