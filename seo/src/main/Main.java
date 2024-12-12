package main;

public class Main {

	public static void main(String[] args) {
		boolean DEBUG = true;
		Quiz quiz = new Quiz();
		char[] num = quiz.mkNum();
		if (DEBUG) {
			System.out.println(num);
		}
		int result = 0;
		while (result < 30) {
			char[] user = quiz.getUserNum();
			result = quiz.judge(user, num);
			System.out.println(result);
		}
		if (result == 30) {
			System.out.println("great!");
		}
	}

}
