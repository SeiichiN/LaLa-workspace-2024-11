package ex3;

public class Main {

	public static void main(String[] args) {
		String pattern1 = ".*";
		String pattern2 = "A\\d{1,2}";  // "A\\d\\d?", "A[0-9]{1,2}"
		String pattern3 = "U[A-Z]{1,3}";
		
		String test = "UABC12345";
		if (test.matches(pattern3)) {
			System.out.println("マッチしてます");
		} else {
			System.out.println("マッチしません");
		}

	}

}
