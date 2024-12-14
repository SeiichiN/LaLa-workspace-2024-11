package main;

public abstract class SetOnMap extends GameLocation {
	private String type;
	
	public SetOnMap(String type, Game game) {
		super(game);
		this.type = type;
		setSelfOnMap();
	}

	public void setSelfOnMap() {
		this.getGame().getMap()[this.getY()][this.getX()] = this;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return type;
	}

}
