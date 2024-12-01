package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends GameLocation {
	public String name;
	public int hp;
	public final int MAXAP = 20;
	public final int MAXHP = 100;
	public List<Item> inventory = new ArrayList<>();
	
	public Player(String name) {
		this.name = name;
		this.hp = 100;
		this.setLocation();
	}
	public void look() {
		System.out.print(this.name + "[" + this.y + ":" + this.x + "] ");
		String thing = Game.map[this.y][this.x];
		String msg = switch (thing) {
			case "goblin" -> "ゴブリンが現れた！";
			case "dragon" -> "ドラゴンが現れた！";
			case "potion" -> "ポーションがある！";
			default -> "何もありません。";
		};
		System.out.println(msg);
	}
	
	public void status() {
		System.out.print(this.name + " [" + this.y + ":" + this.x + "] ");
		System.out.print("HP:" + this.hp + " ");
		inventoryList();
	}
	
	public void inventoryList() {
		System.out.print("持ち物:");
		for (int i = 0; i < inventory.size(); i++) {
			System.out.print("(" + i + ")" + inventory.get(i).type + ",");
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
		System.out.println(this.name + "は" + item.type + "を使った。");
		inventory.remove(item);
		switch (item.type) {
			case "potion" -> { 
				this.hp = MAXHP; 
				System.out.println("HPが" + MAXHP + "になった。");
			}
		}
	}

	public void move(String dir) {
		int _y = this.y;
		int _x = this.x;
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(); }
		case "n" -> { moveUp(); }
		case "s" -> { moveDown(); }
		}
		if (Game.map[y][x].equals("#")) {
			this.y = _y;
			this.x = _x;
			System.out.println("そちらには進めません。");
			return;
		}
		this.look();
	}
	public void moveLeft() {
		this.x -= 1;
		if (this.x < 0) this.x = 0;
	}
	public void moveRight() {
		this.x += 1;
		if (this.x >= Game.XSIZE) this.x = Game.XSIZE - 1;
	}
	public void moveUp() {
		this.y -= 1;
		if (this.y < 0) this.x = 0;
	}
	public void moveDown() {
		this.y += 1;
		if (this.y >= Game.YSIZE) this.y = Game.YSIZE - 1;
	}

	public	List<String> attack(Monster m) {
		List<String> msgList = new ArrayList<>();
		if (this.hp <= 0) { return null; }
		msgList.add(this.name + "の攻撃！");
		int ap = (int)Math.floor(Math.random() * MAXAP);
		m.hp -= ap;
		if (m.hp > 0) {
			msgList.add(m.type + "に対して" + ap + "のダメージを与えた！");
		} else {
			msgList.add(m.type + "を倒した！");
		}
		return msgList;
	}

	public void take(Item it) {
		System.out.print("t:取る > ");
		Scanner scan = new Scanner(System.in);
		String action = scan.nextLine().trim().toLowerCase();
		if (action.equals("t")) {
			this.inventory.add(it);
			Game.map[this.y][this.x] = "."; 
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
}
