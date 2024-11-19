package p104;

public class Main {
	public static void main(String[] args) {
		boolean doorClose = true;
		int count = 0;
		while (doorClose) {
			System.out.println("ノックする");
			System.out.println("1分待つ");
			count++;
			if (count > 9) {
				doorClose = false;
			}
		}
	}
}
