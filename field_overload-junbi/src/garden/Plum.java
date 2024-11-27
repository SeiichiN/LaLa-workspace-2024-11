package garden;

public class Plum extends Flower {
	// このフィールドを有効にすると、smell()は、このフィールドを参照する。
	// したがって、null となる。
	// しかし、このままだと、親クラスのフィールドを参照する。
	// したがって、花 となる。
	public String name;
	
	public Plum () {}
	public Plum (String name) {
		super(name);
	}
	
	public void smell () {
		System.out.println(this.name + "はいい香りがする。");
	}
}
