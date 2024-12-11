package file;

import java.io.FileWriter;
import java.io.IOException;

public class Rensyu {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("hello.txt");
			fw.write("hello!");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}

	}

}
