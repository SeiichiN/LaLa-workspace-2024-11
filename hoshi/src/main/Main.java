package main;

public class Main {

	public static void main(String[] args) {
		Quest quest = new Quest();
		Player player = new Player();
		
		while (true) {
			player.doWard(quest);
			if (player.count > 4) {
				break;
			}
		}
		player.printResult();

	}

}
