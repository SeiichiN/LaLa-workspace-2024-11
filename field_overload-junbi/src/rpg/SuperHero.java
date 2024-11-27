package rpg;

public class SuperHero extends Hero {
	String name;
	public SuperHero(String name) {
		super(name);
	}
	public SuperHero() {
		this("匿名");
	}
	public void run() {
		System.out.println(this.name + "はすばやく逃げ出した。");
		super.run();
	}
}
