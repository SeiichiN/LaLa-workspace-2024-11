package main6;

public class Main3 {

	public static void main(String[] args) {
		String s = "abc,def:ghi";
		String w = s.replaceAll("[ab]", "xy");
		System.out.println(w);

	}

}
