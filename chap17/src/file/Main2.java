package file;

import java.io.FileWriter;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) {
		
		try (FileWriter fw = new FileWriter("data.txt")) {
			fw.write("hello");
		} catch (IOException e) {
			System.out.println("エラー: " + e.getMessage());
		}
 		
		

	}

}
