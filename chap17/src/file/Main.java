package file;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			// fw = new FileWriter("data.txt");
			fw.write("hello!");
		} catch (IOException e) {
			System.out.println("エラー:" + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("nullだよ");
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					;
				}
			}
		}
	}

}
