package main;

public class Main {

	public static void main(String[] args) {
		Player p = new Player("太郎");
		p.setLocation();
		System.out.println(p.name + " y:" + p.y + " x:" + p.x);

		Goblin g = new Goblin("ゴブリン");
		g.setLocation();
		System.out.println(g.type + " y:" + g.y + " x:" + g.x);
		
		Dragon d = new Dragon("ドラゴン");
		d.setLocation();
		System.out.println(d.type + " y:" + d.y + " x:" + d.x);
		
	}

}
