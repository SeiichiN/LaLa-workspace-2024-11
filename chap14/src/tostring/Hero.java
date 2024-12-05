package tostring;

public class Hero {
	String name;
	int hp;
	
	@Override
	public String toString() {
		return "名前：" + this.name + "／HP：" + this.hp;
	}
}
