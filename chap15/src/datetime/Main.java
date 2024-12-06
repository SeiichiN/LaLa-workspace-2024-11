package datetime;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(3000);
		long end = System.currentTimeMillis();
		System.out.println("処理にかかった時間は..." + (end - start) + "ミリ秒でした");	
	}

}
