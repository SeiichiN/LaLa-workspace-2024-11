package set;

import java.util.Set;
import java.util.TreeSet;

public class Main2 {

	public static void main(String[] args) {
		Set<String> words = new TreeSet<>();
		words.add("wolf");
		words.add("dog");
		words.add("panda");
		words.add("cat");
		for (String s : words) {
			System.out.print(s + "->");
		}

	}

}
