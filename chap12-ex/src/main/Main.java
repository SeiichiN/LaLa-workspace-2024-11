package main;

public class Main {

	public static void main(String[] args) {
		X obj = new A();
		obj.a();
		
		Y y1 = new A();
		Y y2 = new B();
		y1.a();    // Aa
		y2.a();    // Ba

		Y[] ys = new Y[2];
		ys[0] = new A();
		ys[1] = new B();
		for (Y y : ys) {
			y.b();     // Ab , Bb
		}
		
	}

}
