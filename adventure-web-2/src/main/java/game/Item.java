package game;

public abstract class Item {
	private String type;
	
	public Item (String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}	
}
