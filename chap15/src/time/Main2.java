package time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main2 {

	public static void main(String[] args) {
		LocalDateTime l1 = LocalDateTime.now();
		System.out.println(l1);  // 2024-12-06T16:12:19.445374200
		
		// LocalDateTime l2 = LocalDateTime.of(2024, 1, 1, 9, 5, 0, 0);
		LocalDateTime l2 = LocalDateTime.of(2024, 1, 1, 9, 5);
		System.out.println(l2);  // 2024-01-01T09:05
		
		ZonedDateTime z1 = l2.atZone(ZoneId.of("Europe/London"));
		System.out.println(z1);  // 2024-01-01T09:05Z[Europe/London]
		
		LocalDateTime l3 = z1.toLocalDateTime();
		System.out.println(l3);  // 2024-01-01T09:05

	}

}
