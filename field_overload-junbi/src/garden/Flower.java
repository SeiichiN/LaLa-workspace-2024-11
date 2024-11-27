package garden;

public class Flower {
	public String name;
	
	public Flower() {
		this.name = "花";
	}
	
	public Flower(String name) {
		this.name = name;
	}
	
	public void bloom() {
		System.out.println(this.name + "が咲いた。");
	}
}
