package ex3;

public class Main {

	public static void main(String[] args) {
		String str = "三";
		try {
			int i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("数字に変換できません");
		}

	}

}
