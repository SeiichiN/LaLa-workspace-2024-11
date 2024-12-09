package main;

public class Player {
	String name;
	int money;
	int count;
	
	public void doWard(Quest quest) {
		count++;
		this.money += quest.work();
		System.out.println("now > " + this.money);
	}
	
	public void printResult() {
		System.out.println("money = " + money);
	}
}
