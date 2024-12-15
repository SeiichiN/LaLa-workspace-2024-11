package game;

import java.util.ArrayList;
import java.util.List;

public abstract class Monster extends SetOnMap {
	private int hp;
	private String attackText;
	private int maxAp;
	
	public Monster(String type, Game game) {
		this(type, "頭突き", 30, game);
	}
	
	public Monster(String type, String attackText, int maxAp, Game game) {
		super(type, game);
		this.hp = 100;
		this.attackText = attackText;
		this.maxAp = maxAp;
	}
		
	public List<String> attack(Player p) {
		List<String> msgList = new ArrayList<>();
		if (this.getHp() <= 0) { return null; }		
		msgList.add(this.getType() + "は" + attackText);
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
	
	public int getMaxAp() { return this.maxAp; }
	public void setMaxAp(int maxAp) { this.maxAp = maxAp; }
	public int getHp() { return this.hp; }
	public void setHp(int hp) {	this.hp = hp; }

	public String getAttackText() {
		return attackText;
	}

	public void setAttackText(String attackText) {
		this.attackText = attackText;
	}
}
