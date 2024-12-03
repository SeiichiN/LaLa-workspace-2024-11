package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends GameLocation {
	private String name;
	private int hp;
	private final int MAXAP = 20;
	private final int MAXHP = 100;
	private List<Item> inventory = new ArrayList<>();
	
	public Player(String name) {
		this.name = name;
		this.hp = 100;
	}
	public void look(Game g) {
		System.out.print(this.name + "[" + this.getY() + ":" + this.getX() + "] ");
		String thing = g.map[this.getY()][this.getX()];
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

	public void move(String dir, Game g) {
		int _y = this.getY();
		int _x = this.getX();
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(g); }
		case "n" -> { moveUp(); }
		case "s" -> { moveDown(g); }
		}
		if (g.map[this.getY()][this.getX()].equals("#")) {
			this.setY(_y);
			this.setX(_x);
			System.out.println("そちらには進めません。");
			return;
		}
		this.look(g);
	}
	private void moveLeft() {
		this.setX(this.getX() - 1);
		if (this.getX() < 0) this.setX(0);
	}
	private void moveRight(Game g) {
		this.setX(this.getX() + 1);
		if (this.getX() >= g.XSIZE) this.setX(g.XSIZE - 1);
	}
	private void moveUp() {
		this.setY(this.getY() - 1);
		if (this.getY() < 0) this.setX(0);
	}
	private void moveDown(Game g) {
		this.setY(this.getY() + 1);
		if (this.getY() >= g.YSIZE) this.setY(g.YSIZE - 1);
	}

	public	void attack(Monster m) {
		if (this.hp <= 0) { return; }
		System.out.println(this.name + "の攻撃！");
		int ap = (int)Math.floor(Math.random() * MAXAP);
		m.setHp(m.getHp() - ap);
		if (m.getHp() > 0) {
			System.out.println(m.getType() + "に対して" + ap + "のダメージを与えた！");
		} else {
			System.out.println(m.getType() + "を倒した！");
		}
	}

	public void take(Item it, Game g) {
		System.out.print("t:取る > ");
		Scanner scan = new Scanner(System.in);
		String action = scan.nextLine().trim().toLowerCase();
		if (action.equals("t")) {
			this.inventory.add(it);
			g.map[this.getY()][this.getX()] = "."; 
		}
	}
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public int getMAXAP() {
		return MAXAP;
	}
	public int getMAXHP() {
		return MAXHP;
	}
	public List<Item> getInventory() {
		return inventory;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
}
