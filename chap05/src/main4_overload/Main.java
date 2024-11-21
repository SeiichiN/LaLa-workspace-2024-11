package main4_overload;

public class Main {
	public static void main(String[] args) {
		// System.out.println(add(10, 20));
		System.out.println(add(3.5, 2.7));
		System.out.println(add("Hello", "World"));
		System.out.println(add(10, 20, 30));
	
	}

	private static int add(int x, int y) {
		int ans = x + y;
		return ans;
	}
	
	private static int add(int x, int y, int z) {
		int ans = x + y + z;
		return ans;
	}

	private static double add(double x, double y) {
		double ans = x + y;
		return ans;
	}

	private static String add(String x, String y) {
		String ans = x + y;
		return ans;
	}
	
}
