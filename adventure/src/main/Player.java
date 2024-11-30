package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends GameLocation {
	String name;
	int hp;
	final int MAXAP = 20;
	final int MAXHP = 100;
	List<Item> inventory = new ArrayList<>();
	
	public Player(String name) {
		this.name = name;
		this.hp = 100;
	}
	public void look(Game g) {
		System.out.print(this.name + "[" + this.y + ":" + this.x + "] ");
		String thing = g.map[this.y][this.x];
		String msg = switch (thing) {
			case "goblin" -> "ゴブリンが現れた！";
			case "dragon" -> "ドラゴンが現れた！";
			case "potion" -> "ポーションがある！";
			default -> "何もありません。";
		};
		System.out.println(msg);
	}
	
	public void status() {
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

	public void move(String dir, Game g) {
		int _y = this.y;
		int _x = this.x;
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(g); }
		case "n" -> { moveUp(); }
		case "s" -> { moveDown(g); }
		}
		if (g.map[y][x].equals("#")) {
			this.y = _y;
			this.x = _x;
			System.out.println("そちらには進めません。");
			return;
		}
		this.look(g);
	}
	public void moveLeft() {
		this.x -= 1;
		if (this.x < 0) this.x = 0;
	}
	public void moveRight(Game g) {
		this.x += 1;
		if (this.x >= g.XSIZE) this.x = g.XSIZE - 1;
	}
	public void moveUp() {
		this.y -= 1;
		if (this.y < 0) this.x = 0;
	}
	public void moveDown(Game g) {
		this.y += 1;
		if (this.y >= g.YSIZE) this.y = g.YSIZE - 1;
	}

	public	void attack(Monster m) {
		if (this.hp <= 0) { return; }
		System.out.println(this.name + "の攻撃！");
		int ap = (int)Math.floor(Math.random() * MAXAP);
		m.hp -= ap;
		if (m.hp > 0) {
			System.out.println(m.type + "に対して" + ap + "のダメージを与えた！");
		} else {
			System.out.println(m.type + "を倒した！");
		}
	}

	public void take(Item it, Game g) {
		System.out.print("t:取る > ");
		Scanner scan = new Scanner(System.in);
		String action = scan.nextLine().trim().toLowerCase();
		if (action.equals("t")) {
			this.inventory.add(it);
			g.map[this.y][this.x] = "."; 
		}
	}
}
