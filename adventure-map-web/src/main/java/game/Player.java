package game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player extends GameLocation {
	private String name;
	private int hp;
	public static final int MAXHP = 100;
	private List<Item> itemList = new ArrayList<>();
	private int gold;
	
	public Player(String name, Game game) {
		super(game);
		this.name = name;
		this.hp = MAXHP;
	}
	
	public void use() {
		System.out.print("持ち物:");
		for (int i = 0; i < this.itemList.size(); i++) {
			System.out.print(" [" + i+ "]:" + this.itemList.get(i).getType());
		}
		Scanner scan = new Scanner(System.in);
		int num = 0;
		do {
			System.out.print(" どれを使いますか？ > ");
			try {
				String _num = scan.nextLine();
				num = Integer.parseInt(_num);
			} catch (NumberFormatException e) {
				return;
			}
		} while (num < 0 || num >= this.itemList.size());
		Item item = this.itemList.get(num);
		String itemType = item.getType();
		switch (itemType) {
		case "potion" -> { 
			if (item instanceof Potion p) {
				System.out.println(this.getName() + "は" + p.getType() + "を使った。");
				System.out.println(this.getName() + "のHPが" + p.getRp() + "に回復した。");
				this.setHp(p.getRp());
				this.itemList.remove(p);
			}
		}
		case "ether" -> {
			if (item instanceof Ether e) {
				System.out.println(this.name + "は" + e.getType() + "を使った。");
				System.out.println("エーテル:" + e.getRmp());
				this.itemList.remove(e);
			}
		}
		}
		this.getGame().getMap()[item.getY()][item.getX()] = null;
	}
	
	public void take(Item item) {
		System.out.print(item.getType() + "を取りますか？ (y/n) > ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().toLowerCase();
		if (str.equals("y")) {
			this.itemList.add(item);
			this.getGame().getMap()[this.getY()][this.getX()] = null;
		}
	}
	
	public void take(Gold gold) {
		this.setGold(this.getGold() + gold.getGold());
		this.getGame().getMap()[gold.getY()][gold.getX()] = null;
		System.out.println("GOLDを" + gold.getGold() + "手に入れた。");
	}
	
	public void status() {
		String text = "HP:" + this.getHp() + " 装備:";
		for (Item i : itemList) {
			text = text + i.getType() + ",";
		}
		text += " Gold:" + this.gold;
		System.out.println(text);
		// this.use();
	}
	
	public List<String> attack(Monster m) {
		List<String> msgList = new ArrayList<>();
		if (this.hp <= 0) { return null; }
		msgList.add(this.getName() + "は剣で切りつけた。");
		int ap = (int)Math.floor(Math.random() * 31);
		if (ap == 0) {
			msgList.add(this.getName() + "の攻撃は失敗した！");
		} else {
			m.setHp(m.getHp() - ap);
			msgList.add(m.getType() + "に" + ap + "ポイントのダメージを与えた！");
		}
		if (m.getHp() <= 0) {
			msgList.add(m.getType() + "を倒した。");
			msgList.add("報酬としてGoldを" + Game.REWARD + "手に入れた。");
			this.setGold(this.getGold() + Game.REWARD);
			this.getGame().getMap()[m.getY()][m.getX()] = null;
		}		
		return msgList;
	}
	
	public String look() {
		SetOnMap soMapObj = this.getGame().getMap()[this.getY()][this.getX()];
		if (soMapObj == null) { return "何もありません。"; }
		String thing = soMapObj.toString();
		String msg = switch (thing) {
			case "goblin" -> "ゴブリンが現れた！";
			case "dragon" -> "ドラゴンが現れた！";
			case "potion" -> "ポーションがある！";
			case "ether" -> "エーテルがある！";
			case "Gold" -> "ゴールドがある！";
			default -> "何もありません。";
		};
		return msg;
	}

	
	public String toString() {
		return name + " HP:" + hp;
	}
	
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public String move(String dir) {
		int _y = this.getY();
		int _x = this.getX();
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(); }
		case "n" -> { moveUp(); }
		case "s" -> { moveDown(); }
		}
		if (this.getGame().getMap()[this.getY()][this.getX()] instanceof NotEnter) {
			this.setY(_y);
			this.setX(_x);
			return "そちらには行けません。";
		}
		return this.look();
	}
	private void moveLeft() {
		this.setX(this.getX() - 1);
		if (this.getX() < 0) { this.setX(0);	}
	}
	private void moveRight() {
		this.setX(this.getX() + 1);
		if (this.getX() >= Game.XSIZE) { this.setX(Game.XSIZE - 1);	}
	}
	private void moveUp() {
		this.setY(this.getY() - 1);
		if (this.getY() < 0) { this.setY(0);	}
	}
	private void moveDown() {
		this.setY(this.getY() + 1);
		if (this.getY() >= Game.YSIZE) { this.setY(Game.YSIZE - 1);	}
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void setName(String name) {
		this.name = name;
	}
}
