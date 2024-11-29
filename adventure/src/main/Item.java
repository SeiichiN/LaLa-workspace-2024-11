package main;

public abstract class Item extends GameLocation
                           implements SetSelfOnMap {
	String type;
	
	public Item (String type) {
		this.type = type;
	}
	
	public void setSelfOnMap(Game g) {
		g.map[this.y][this.x] = this.type;
	}	
}
