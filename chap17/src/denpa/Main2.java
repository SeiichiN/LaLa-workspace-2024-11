package denpa;

import java.io.FileWriter;
import java.io.IOException;

public class Main2 {

	public static void subsub() throws IOException {
		FileWriter fw = new FileWriter("data.txt");
	}
	
	public static void sub() {
		try {
			subsub();
		} catch (IOException e) {
			;
		}
	}
	
	public static void main(String[] args) {
		sub();
	}

}
