package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main4 {

	public static void main(String[] args) throws ParseException {
		// String FORMAT = "yyyy/MM/dd HH:mm:ss";
		String FORMAT = "yyyy/MM/dd";
		SimpleDateFormat f = new SimpleDateFormat(FORMAT);
		// Date d = f.parse("2023/09/18 05:53:20");
		Date d = f.parse("2023/09/18");
		System.out.println(d);
		
		Date now = new Date();
		String s = f.format(now);
		System.out.println("現在は" + s + "です");

	}

}
