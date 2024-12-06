package datetime;

import java.util.Date;

public class Main2 {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		Date past = new Date(1694984000000L);
		// Date past = new Date(1985, 6, 4, 0, 0, 0);
		System.out.println(past);

	}

}
