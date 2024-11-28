package test;

public class SuperHero extends Hero {
	// String name = "スーパー名無し";
	
	@Override
	public void run() {
		System.out.println(this.name + "はすばやく逃げ出した。");
	}
}
