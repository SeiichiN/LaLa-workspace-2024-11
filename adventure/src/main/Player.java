package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player extends GameLocation {
	private String name;
	private int hp;
	private List<Item> itemList = new ArrayList<>();
	private int gold;
	
	public Player(String name) {
		this.name = name;
		this.hp = 100;
		setLocation();
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
				num = scan.nextInt();
			} catch (InputMismatchException e) {
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
		Game.map[item.getY()][item.getX()] = ".";
	}
	
	public void take(Item item) {
		System.out.print(item.getType() + "を取りますか？ (y/n) > ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().toLowerCase();
		if (str.equals("y")) {
			this.itemList.add(item);
			Game.map[this.getY()][this.getX()] = ".";
		}
	}
	
	public void take(Gold gold) {
		this.gold += gold.getGold();
		Game.map[gold.getY()][gold.getX()] = ".";
		System.out.println("GOLDを" + gold.getGold() + "手に入れた。");
	}
	
	public void status() {
		String text = "HP:" + this.getHp() + " 装備:";
		for (Item i : itemList) {
			text = text + i.getType() + ",";
		}
		text = " Gold:" + this.gold;
		System.out.println(text);
		this.use();
	}
	
	public void attack(Monster m) {
		if (this.hp <= 0) { return; }
		System.out.println(this.getName() + "は剣で切りつけた。");
		int ap = (int)Math.floor(Math.random() * 31);
		if (ap == 0) {
			System.out.println(this.getName() + "の攻撃は失敗した！");
		} else {
			m.setHp(m.getHp() - ap);
			System.out.println(m.getType() + "に" + ap + "ポイントのダメージを与えた！");
		}
		if (m.getHp() <= 0) {
			System.out.println(m.getType() + "を倒した。");
			System.out.println("報酬としてGoldを" + Game.REWARD + "手に入れた。");
			this.gold += Game.REWARD;
			Game.map[m.getY()][m.getX()] = ".";
		}		
	}
	
	public void look() {
		System.out.print("[" + getY() + ":" + getX() + "] ");
		System.out.println(Game.map[getY()][getX()]);
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
	
	public void move(String dir) {
		int _y = this.getY();
		int _x = this.getX();
		switch (dir) {
		case "w" -> { moveLeft(); }
		case "e" -> { moveRight(); }
		case "n" -> { moveUp(); }
		case "s" -> { moveDown(); }
		}
		if (Game.map[this.getY()][this.getX()].equals("#")) {
			System.out.println("そちらには行けません。");
			this.setY(_y);
			this.setX(_x);
		}
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
}
