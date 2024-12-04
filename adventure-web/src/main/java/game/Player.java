package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends GameLocation {
	private String name;
	private int hp;
	private final int MAXAP = 20;
	private final int MAXHP = 100;
	private List<Item> inventory = new ArrayList<>();
	
	public Player(Game game) {
		this("", game);
	}
	public Player(String name, Game game) {
		super(game);
		this.name = name;
		this.hp = 100;
		this.setLocation();
	}
	public void look() {
		System.out.print(this.name + "[" + this.getY() + ":" + this.getX() + "] ");
		String thing = this.getGame().map[this.getY()][this.getX()];
		String msg = switch (thing) {
			case "goblin" -> "ゴブリンが現れた！";
			case "dragon" -> "ドラゴンが現れた！";
			case "potion" -> "ポーションがある！";
			default -> "何もありません。";
		};
		System.out.println(msg);
	}
	
	public void status() {
		System.out.print(this.name + " [" + this.getY() + ":" + this.getX() + "] ");
		System.out.print("HP:" + this.hp + " ");
		inventoryList();
	}
	
	public void inventoryList() {
		System.out.print("持ち物:");
		for (int i = 0; i < inventory.size(); i++) {
			System.out.print("(" + i + ")" + inventory.get(i).getType() + ",");
		}
		System.out.println();
	}
	
	public void use() {
		inventoryList();
		System.out.print("何を使いますか？ > ");
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		int n = Integer.parseInt(num);
		use(inventory.get(n));
	}
	
	public void use(Item item) {
		System.out.println(this.name + "は" + item.getType() + "を使った。");
		inventory.remove(item);
		switch (item.getType()) {
			case "potion" -> { 
				this.hp = MAXHP; 
				System.out.println("HPが" + MAXHP + "になった。");
			}
		}
	}

	public void move(String dir) {
		int _y = this.getY();
		int _x = this.getX();
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(); }
		case "n" -> { moveUp(); }
		case "s" -> { moveDown(); }
		}
		if (this.getGame().map[this.getY()][this.getX()].equals("#")) {
			this.setY(_y);
			this.setX(_x);
			System.out.println("そちらには進めません。");
			return;
		}
		this.look();
	}
	public void moveLeft() {
		this.setX(this.getX() - 1);
		if (this.getX() < 0) this.setX(0);
	}
	public void moveRight() {
		this.setX(this.getX() + 1);
		if (this.getX() >= Game.XSIZE) this.setX(Game.XSIZE - 1);
	}
	public void moveUp() {
		this.setY(this.getY() - 1);
		if (this.getY() < 0) this.setY(0);
	}
	public void moveDown() {
		this.setY(this.getY() + 1);
		if (this.getY() >= Game.YSIZE) this.setY(Game.YSIZE - 1);
	}

	public	List<String> attack(Monster m) {
		List<String> msgList = new ArrayList<>();
		if (this.hp <= 0) { return null; }
		msgList.add(this.name + "の攻撃！");
		int ap = (int)Math.floor(Math.random() * MAXAP);
		m.setHp(m.getHp() - ap);
		if (m.getHp() > 0) {
			msgList.add(m.getType() + "に対して" + ap + "のダメージを与えた！");
		} else {
			msgList.add(m.getType() + "を倒した！");
		}
		return msgList;
	}

	public void take(Item it) {
		System.out.print("t:取る > ");
		Scanner scan = new Scanner(System.in);
		String action = scan.nextLine().trim().toLowerCase();
		if (action.equals("t")) {
			this.inventory.add(it);
			this.getGame().map[this.getY()][this.getX()] = "."; 
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public List<Item> getInventory() {
		return inventory;
	}
}
