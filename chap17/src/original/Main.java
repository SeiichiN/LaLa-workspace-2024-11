package original;

public class Main {

	public static void main(String[] args) {
		String filename = "audio.txt";
		try {
			if (filename.endsWith(".txt")) {
				throw new UnsupportedMusicFileException
				("未対応のファイルです");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
