package rpg;

public class Hero {
	String name;
	
	public Hero() {
		this("名無し");
	}
	
	public Hero(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println(this.name + "は逃げ出した。");
	}
}
