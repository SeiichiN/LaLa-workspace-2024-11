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
		msgList.add(this.getType() + "は斧で切りつけた。");
		msgList.addAll(super.attack(p));
		return msgList;
	}
}
