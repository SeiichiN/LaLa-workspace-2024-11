package main01;

public class ArraySample {

	public static void main(String[] args) {
		
		String[] names = new String[3];
		
		names[0] = "たなか";
		names[1] = "すずき";
		names[2] = "さいとう";
		
		for (String name : names) {
			System.out.println(name);
		}
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}

}
