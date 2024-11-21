package main6;

// p.204
public class Main2 {

	public static void main(String[] args) {
		int[] array = makeArray(3);
		for (int i : array) {
			System.out.println(i);
		}
	}
	
	public static int[] makeArray(int size) {
		int[] newArray = new int[size];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = i + 10;
		}
		return newArray;
	}

}
