package ex5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);   // 2024-12-09
		
		LocalDate mirai = now.plusDays(100);
		System.out.println(mirai);  // 2025-03-19

		String FORMAT = "西暦yyyy年MM月dd日";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(FORMAT);
		String s = mirai.format(fmt);
		System.out.println(s);    // 西暦2025年03月19日
	}

}
