package hosoku;

public class Dragon {
	private static Dragon dragon = new Dragon();

	private Dragon() {}
	
	public static Dragon getInstance() {
		return dragon;
	}
}
