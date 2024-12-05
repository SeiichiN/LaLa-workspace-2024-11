package _static;

public class Hero {
	String name;
	int hp;
	static int money;
	
	public static void setRandomMoney() {
		Hero.money = (int)(Math.random() * 1000);  // 0..999
		System.out.println("Heroたちの所持金を初期化しました");
	}
	
	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", money=" + money + "]";
		
	}
	

}
