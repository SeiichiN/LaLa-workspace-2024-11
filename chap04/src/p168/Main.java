package p168;

public class Main {

	public static void main(String[] args) {
		int[][] scores = {
				{40, 50, 60},
				{80, 60, 70},
		};
		System.out.println(scores.length);    // 2
		System.out.println(scores[0].length); // 3
		
		for (int[] row : scores) {
			for (int num : row) {
				System.out.println(num);
			}
		}
		
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				System.out.println(scores[i][j]);
			}
		}
		
		
		
	}

}
