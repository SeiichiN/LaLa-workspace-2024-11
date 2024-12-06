package time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

	public static void main(String[] args) {
		// now()で現在を取得できる
		Instant i = Instant.now();
		System.out.println(i);        // 2024-12-06T06:34:50.865971600Z
		
		// ミリ秒でその瞬間を取得できる
		Instant i2 = Instant.ofEpochMilli(1600705425827L);
		System.out.println(i2);       // 2020-09-21T16:23:45.827Z
		long l = i2.toEpochMilli();
		System.out.println(l);         // 1600705425827
		
		// ZonedDateTimeクラス
		ZonedDateTime z1 = ZonedDateTime.now();
		System.out.println(z1);  // 2024-12-06T15:42:13.936598+09:00[Asia/Tokyo]
		
		ZonedDateTime z2 = ZonedDateTime.of(2023, 1,2,3,4,5,6, ZoneId.of("Asia/Tokyo"));
		System.out.println(z2);  // 2023-01-02T03:04:05.000000006+09:00[Asia/Tokyo]

		// Instantクラスは世界標準時で瞬間を表す
		Instant i3 = z2.toInstant();
		System.out.println(i3);  // 2023-01-01T18:04:05.000000006Z
		// ZoneId情報が追加される
		ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));
		System.out.println(z3);  // 2023-01-01T18:04:05.000000006Z[Europe/London]
		
		System.out.println("東京:" + z2.getYear() + z2.getMonth() + z2.getDayOfMonth());
		// 東京:2023JANUARY2
		System.out.println("ロンドン:" + z3.getYear() + z3.getMonth() + z3.getDayOfMonth());
		// ロンドン:2023JANUARY1
		if (z2.isEqual(z3)) {
			System.out.println("同じ瞬間です");
		}
		
		
	}

}
