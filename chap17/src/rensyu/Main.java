package rensyu;

public class Main {
	
	public static int getNum() {
		int num = 0;
		boolean repeat = true;
		do {
			System.out.print("数字を入力してください > ");
			try {
				String numtxt = new java.util.Scanner(System.in).nextLine();
				num = Integer.parseInt(numtxt);
				repeat = false;
			} catch (NumberFormatException e) {
				System.out.println("数字ではないよ");
			}
		} while (repeat);
		return num;
	}

	public static void main(String[] args) {
		int num = getNum();
		System.out.println(num);
	}
	
	

}
