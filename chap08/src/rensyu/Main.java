package rensyu;

public class Main {

	public static void main(String[] args) {
		
		Cleric c = new Cleric();
		c.name = "クレア";
		// 聖職者はマタンゴと戦い、HPが20になった。
		c.hp = 20;
		c.selfAid();
		int sec = 5;
		int recovery = c.pray(sec);
		System.out.println(c.name + "は、" + sec + "秒間祈った。");
		System.out.println("MPが" + recovery + "回復した。");
		
	}

}
