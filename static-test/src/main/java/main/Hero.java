package main;

public class Hero {
	private static String name;
	private static int hp;
	
	public static String getName() {
		return name;
	}
	public static synchronized void setName(String name) {
		Hero.name = name;
	}
	public static int getHp() {
		return hp;
	}
	public static void setHp(int hp) {
		Hero.hp = hp;
	}
	
}
