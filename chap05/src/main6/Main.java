package main6;

public class Main {

	public static void main(String[] args) {
		int[] x = {10, 20, 30};
		methodA(x);
		for (int i : x) {
			System.out.println(i);
		}
	}
	
	public static void methodA(int[] x) {
		for (int i = 0; i < x.length; i++) {
			x[i]++;
		}
	}

}
