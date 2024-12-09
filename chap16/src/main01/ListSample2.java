package main01;

import java.util.ArrayList;

public class ListSample2 {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<>();
		names.add("たなか");
		names.add("すずき");
		names.add("さいとう");
		
		System.out.println(names.get(1));
		
		for (String name : names) {
			System.out.println(name);
		}
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}	}

}
