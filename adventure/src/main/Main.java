package main;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		Goblin g = new Goblin("ゴブリン");
		g.setLocation(game);
		g.setSelfOnMap(game);
		System.out.println(g.type + " y:" + g.y + " x:" + g.x + " " + game.map[g.y][g.x]);
		
		Dragon d = new Dragon("ドラゴン");
		d.setLocation(game);
		d.setSelfOnMap(game);
		System.out.println(d.type + " y:" + d.y + " x:" + d.x + " " + game.map[d.y][d.x]);
		
		Player p = new Player("太郎");
		p.setLocation(game);
		System.out.println(p.name + " y:" + p.y + " x:" + p.x);

	}

}
