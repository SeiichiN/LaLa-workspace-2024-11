package main;

public abstract class Item extends GameLocation
                           implements SetSelfOnMap {
	String type;
	
	public Item (String type) {
		this.type = type;
		this.setLocation();
		this.setSelfOnMap();
	}
	
	public void setSelfOnMap() {
		Game.map[this.y][this.x] = this.type;
	}	
}
