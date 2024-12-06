package concatenate;

public class Main {

	public static void main(String[] args) {
		// start
		long start = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append("java");
			if (i % 100 == 0) {
				sb.append("\n");
			}
		}
		String s = sb.toString();		
		System.out.println(s);
		// end
		long end = System.currentTimeMillis();
		System.out.println("処理にかかった時間は..." + (end - start) + "ミリ秒でした");	
		// 処理にかかった時間は...7ミリ秒でした
	}

}
