package game;

import java.util.ArrayList;
import java.util.List;

public class Goblin extends Monster {
	public Goblin(String type) {
		super(type);
	}

	@Override
	public List<String> attack(Player p) {
		List<String> msgList = new ArrayList<>();
		msgList.add(this.type + "は斧で切りつけた。");
		List<String> msgList2 = super.attack(p);
		msgList.addAll(msgList2);
		return msgList;
	}
}
