package game;

public class Main {

	public static void main(String[] args) {
		String[][] map = {
				{".", ".", ".", ".", "."},	
				{".", "gold", ".", ".", "."},	
				{".", ".", ".", "goblin", "."},	
				{".", ".", ".", ".", "."},	
				{".", ".", "potion", ".", "."},	
		};
		int y = 2;
		int x = 3;
		System.out.println(map[y][x]);
	}

}
