package p154;

public class Main {

	public static void main(String[] args) {
		char[] base = {'A', 'T', 'G', 'C'};
		int[] seq = new int[10];
		
		for (int i = 0; i < seq.length; i++) {
			seq[i] = new java.util.Random().nextInt(4);
		}
		
		for (int i = 0; i < seq.length; i++) {
			System.out.print(base[seq[i]] + " ");
		}

	}

}
