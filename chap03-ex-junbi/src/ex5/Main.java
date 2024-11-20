package ex5;

public class Main {

	public static void main(String[] args) {
		System.out.print("1:検索 2:登録 3:削除 4:変更 > ");
		int selected = new java.util.Scanner(System.in).nextInt();
		String str = switch(selected) {
		case 1 -> "検索します";
		case 2 -> "登録します";
		case 3 -> "削除します";
		case 4 -> "変更します";
		default -> "無効な値です";
		};
		System.out.println(str);
	}

}
