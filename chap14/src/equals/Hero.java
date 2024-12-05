package equals;

public class Hero {
	String name;
	int hp;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} 
		// p.453 キャストして変数hに代入する
		if (o instanceof Hero h) {
			if (this.name.equals(h.name)) {
				return true;
			}
		}
		return false;
	}
}
