package main;

public abstract class Item extends GameLocation
                           implements SetSelfOnMap {
	private String type;
	
	public Item (String type) {
		this.type = type;
	}
	
	public void setSelfOnMap(Game g) {
		g.map[this.getY()][this.getX()] = this.type;
	}
	
	public String getType() {
		return this.type;
	}
}
