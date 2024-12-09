package ex2;

public class Main {
	public static String makeFileName(String folder, String file) {
		if (!folder.endsWith("\\")) {
			folder = folder + "\\";
		}
		return folder + file;
	}

	public static void main(String[] args) {
		String folderA = "c:\\javadev";
		String file = "readme.txt";
		String filename1 = makeFileName(folderA, file);
		
		String folderB = "c:\\javadev\\";
		String filename2 = makeFileName(folderB, file);

		if (filename1.equals(filename2)) {
			System.out.println("同じ");
		} else {
			System.out.println("違う");
		}
	}
	
}
