package main01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSample {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("たなか");
		names.add("すずき");
		names.add("さいとう");
		
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}
	}

}
