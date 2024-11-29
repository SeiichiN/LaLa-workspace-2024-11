package main;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		Goblin g = new Goblin("goblin");
		g.setLocation(game);
		g.setSelfOnMap(game);
		
		Dragon d = new Dragon("dragon");
		d.setLocation(game);
		d.setSelfOnMap(game);
		
		Potion po = new Potion("potion");
		po.setLocation(game);
		po.setSelfOnMap(game);
		
		Player p = new Player("太郎");
		p.setLocation(game);
		System.out.println(p.name + " y:" + p.y + " x:" + p.x);

		game.printMap();  // mapを表示
		// p.move("w");  // ←に
		// p.move("n");  // ↑に
	}

}
