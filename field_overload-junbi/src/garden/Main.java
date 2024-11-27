package garden;

public class Main {

	public static void main(String[] args) {
		Flower f = new Flower();
		f.bloom();
		
		Rose r = new Rose("バラ");
		r.smell();

		Plum p = new Plum("ウメ");
		p.smell();
	}

}
