package ex1;

public class Main {

	public static void main(String[] args) {
		try {
			String s = null;
			System.out.println(s.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException例外をchatchしました");
			System.out.println("ーースタックトレースーー(ここから)");
			e.printStackTrace();
			System.out.println("ーースタックトレースーー(ここまで)");
		}

	}

}
