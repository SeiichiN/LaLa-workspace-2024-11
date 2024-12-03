package rpg;

public class Wand {
	private String name;
	private double power;
	
	public Wand(String name, double power) {
		this.setName(name);
		this.setPower(power);
	}
	public Wand(String name) {
		this.setName(name);
		double power = (Math.random() * 99.5) + 0.5;
		setPower(power);
	}
	
	public String getName() {
		return this.name;
	}
	public double getPower() {
		return this.power;
	}
	
	public void setName(String name) {
		if (name.length() < 3) {
			throw new IllegalArgumentException("名前が短すぎます。");
		}
		this.name = name;
	}
	
	public void setPower(double power) {
		if (power < 0.5 || power > 100) {
			throw new IllegalArgumentException("0.5 <= 増幅率 <= 100");
		}
		this.power = power;
	}
}
