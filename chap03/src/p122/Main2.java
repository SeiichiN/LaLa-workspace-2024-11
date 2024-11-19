package p122;

public class Main2 {

	public static void main(String[] args) {
		System.out.println("年齢を入力してください > ");
		int age = new java.util.Scanner(System.in).nextInt();
		String s = age >= 18 ? "成人" : "未成年";
		System.out.println(s);

	}

}
