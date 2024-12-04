package main;

public class NotEnter extends GameLocation implements SetSelfOnMap {
	private String type;
	
	public NotEnter() {
		this("#");
	}
	
	public NotEnter(String type) {
		this.type = type;
		setLocation();
		setSelfOnMap();
	}
	
	@Override
	public void setSelfOnMap() {
		Game.map[this.getY()][this.getX()] = this.type;
		
	}
	
	public String getType() {
		return this.type;
	}

}
