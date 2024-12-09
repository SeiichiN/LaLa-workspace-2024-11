package ex4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);

		Calendar c = Calendar.getInstance();
		c.setTime(now);
		System.out.println(c);
		
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		c.set(Calendar.DAY_OF_MONTH, (day + 100));
		System.out.println(c);
		
		Date d = c.getTime();
		System.out.println(d);
		
		String FORMAT = "西暦yyyy年MM月dd日";
		SimpleDateFormat f = new SimpleDateFormat(FORMAT);
		String s = f.format(d);
		System.out.println(s);
	}

}
