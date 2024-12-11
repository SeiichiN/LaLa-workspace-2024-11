package game;

import java.util.ArrayList;
import java.util.List;

public abstract class Monster  {
	private String type;
	private int hp;
	private final int MAXAP = 20;
	
	public Monster(String type) {
		this.type = type;
		this.hp = 100;
	}
	
	public	List<String> attack(Player p) {
		List<String> msgList = new ArrayList<>();
		if (this.hp <= 0) {
			return msgList; 
		}
		msgList.add(this.type + "の攻撃！");
		int ap = (int)Math.floor(Math.random() * MAXAP);
		p.setHp(p.getHp() - ap);
		if (p.getHp() > 0) {
			msgList.add(p.getName() + "に対して" + ap + "のダメージを与えた！");
		} else {
			msgList.add(p.getName() + "を倒した！");
		}
		return msgList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
