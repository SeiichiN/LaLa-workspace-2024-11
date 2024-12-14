package game;

import java.util.ArrayList;
import java.util.List;

public abstract class Monster extends SetOnMap {
	private int hp;
	private String weapon;
	private int maxAp;
	
	public Monster(String type, Game game) {
		this(type, "頭突き", 30, game);
	}
	
	public Monster(String type, String weapon, int maxAp, Game game) {
		super(type, game);
		this.hp = 100;
		this.weapon = weapon;
		this.maxAp = maxAp;
	}
		
	public List<String> attack(Player p) {
		List<String> msgList = new ArrayList<>();
		if (this.getHp() <= 0) { return null; }		
		msgList.add(getAttackText());
		int ap = (int)Math.floor(Math.random() * this.getMaxAp());
		if (ap == 0) {
			msgList.add(this.getType() + "の攻撃失敗。");
		} else {
			p.setHp(p.getHp() - ap);
			msgList.add(p.getName() + "に" + ap + "ポイントのダメージ");
		}
		if (p.getHp() <= 0) {
			msgList.add(p.getName() + "を倒した。");
		}
		return msgList;
	}
	
	public String getAttackText() {
		return this.getType() + "の" + this.weapon + "による攻撃!"; 
	}
	public int getMaxAp() { return this.maxAp; }
	public void setMaxAp(int maxAp) { this.maxAp = maxAp; }
	public String getWeapon() {	return this.weapon;	}
	public void setWeapon(String weapon) { this.weapon = weapon; }
	public int getHp() { return this.hp; }
	public void setHp(int hp) {	this.hp = hp; }
}
