package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat f1 = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("あなたの誕生日は？");
		String s = new Scanner(System.in).nextLine();
		Date birthday = f1.parse(s);
		
		SimpleDateFormat f2 = new SimpleDateFormat("西暦yyyy年MM月dd日");
		String birth = f2.format(birthday);
		System.out.println("あなたの誕生日は" + birth + "ですね");
	}

}
