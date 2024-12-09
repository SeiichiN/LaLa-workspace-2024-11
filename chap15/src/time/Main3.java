package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main3 {

	public static void main(String[] args) {
		DateTimeFormatter fmt = 
				DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate ldate =
				LocalDate.parse("2023/09/30", fmt);
		System.out.println(ldate);    // 2023-09-30
		
		LocalDate ldatep = ldate.plusDays(100);
		System.out.println(ldatep);   // 2026-06-26
		
		String str = ldatep.format(fmt);
		System.out.println(str);    // 2026/06/26
		
		LocalDate now = LocalDate.now();
		System.out.println(now);   // 2024-12-09
		
		// nowがldatepよりも"後"ならtrue
		if (now.isAfter(ldatep)) {
			System.out.println(ldatep + "は過去です");
		}
		if (now.isBefore(ldatep)) {
			System.out.println(ldatep + "は未来です");
			// 2026-06-26は未来です
		}
		
	}

}
