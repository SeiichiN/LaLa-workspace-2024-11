package game;

public class NotEnter extends GameLocation implements SetSelfOnMap {
	private String type;
	
	public NotEnter(Game game) {
		this("#", game);
	}
	
	public NotEnter(String type, Game game) {
		super(game);
		this.type = type;
		setLocation();
		setSelfOnMap();
	}
	
	@Override
	public void setSelfOnMap() {
		this.getGame().getMap()[this.getY()][this.getX()] = this.type;
		
	}
	
	public String getType() {
		return this.type;
	}

}
