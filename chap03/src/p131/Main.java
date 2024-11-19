package p131;

public class Main {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				int k = i * j;
				System.out.print(k);
				if (k < 10) {
					System.out.print(" ");
				} 
				System.out.print(" ");
			}
			System.out.println("");
		}

	}

}
