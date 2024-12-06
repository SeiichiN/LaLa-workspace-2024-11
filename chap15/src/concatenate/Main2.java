package concatenate;

public class Main2 {

	public static void main(String[] args) {
		// start
		long start = System.currentTimeMillis();
		System.out.println(start);
		
		String s = "";
		for (int i = 0; i < 10000; i++) {
			s = s + "Java";
			if (i % 100 == 0) {
				s = s + "\n";
			}
		}
		System.out.println(s);
		// end
		long end = System.currentTimeMillis();
		System.out.println("処理にかかった時間は..." + (end - start) + "ミリ秒でした");	
		// 処理にかかった時間は...94ミリ秒でした
	}

}
