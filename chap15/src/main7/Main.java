package main7;

public class Main {

	public static void main(String[] args) {
		Hero hero = new Hero();
		final String FORMAT = "%-9s %-13s 所持金%,6d";
		String s = String.format(FORMAT, hero.getName(), hero.getJob(), hero.getGold());
		System.out.println(s);

	}

}
