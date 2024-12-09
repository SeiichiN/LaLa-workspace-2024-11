package game;

import java.util.ArrayList;
import java.util.List;

public class Dragon extends Monster {
	public Dragon(String type, Game game) {
		super(type, game);
	}

	@Override
	public List<String> attack(Player p) {
		List<String> msgList = new ArrayList<>();
		msgList.add(this.getType() + "は口から火を噴いた。");
		msgList.addAll(super.attack(p));
		return msgList;
	}

}
