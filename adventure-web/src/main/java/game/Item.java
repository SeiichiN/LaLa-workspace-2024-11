package game;

public abstract class Item extends GameLocation
                           implements SetSelfOnMap {
	private String type;
	
	public Item (String type, Game game) {
		super(game);
		this.type = type;
		this.setLocation();
		this.setSelfOnMap();
	}
	
	public void setSelfOnMap() {
		this.getGame().map[this.getY()][this.getX()] = this.type;
	}

	public String getType() {
		return type;
	}	
}
