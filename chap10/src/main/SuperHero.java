package main;

public class SuperHero extends Hero {
	boolean flying;
		
	public void fly() {
		this.flying = true;
		System.out.println("飛び上がった！");
	}
	
	public void land() {
		this.flying = false;
		System.out.println("着地した！");
	}
	@Override 
	public void run() {
		System.out.println("撤退した！");
	}
	
}
