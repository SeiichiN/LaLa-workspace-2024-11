package ex4;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		try {
			throw new IOException("IOエラー");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "です");
		}
		
		System.out.println("処理終了");
	}

}
