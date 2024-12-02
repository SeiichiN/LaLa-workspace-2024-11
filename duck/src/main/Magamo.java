package main;

public class Magamo extends FlySwimBird {
	public Magamo(String name) {
		super(name);
	}

	@Override
	public void say() {
		System.out.println(this.name + "はガアガアと鳴く。");
	}
	
}
