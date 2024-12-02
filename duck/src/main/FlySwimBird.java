package main;

public abstract class FlySwimBird extends Bird 
                             implements Flying, Swimming {
	
	public FlySwimBird(String name) {
		super(name);
	}

	@Override
	public void fly() {
		System.out.println(this.name + "はバサバサと飛ぶ。");
	}
	
	@Override
	public void swim() {
		System.out.println(this.name + "はスイスイ泳ぐ。");
	}
}
