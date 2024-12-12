package nageru;

public class Person {
	int age;
	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("年齢は０以上です。age=" + age);
			// IllegalStateException("プログラムの状態がおかしい");
		}
		this.age = age;
	}
}
