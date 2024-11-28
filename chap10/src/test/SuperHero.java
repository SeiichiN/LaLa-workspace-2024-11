package test;

public class SuperHero extends Hero {
	// String name = "アサカ";
	
	@Override
	public void run() {
		System.out.println("親のnameは" + super.name + "です。");
		System.out.println(this.name + "はすばやく逃げ出した。");
	}
}
