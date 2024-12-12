package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz {
	public char[] mkNum() {
		List<Character> numbers = mkList();
		char[] num = new char[3];
		num[0] = numbers.get(0);
		num[1] = numbers.get(1);
		num[2] = numbers.get(2);
		return num;
	}
	
	public List<Character> mkList() {
		List<Character> numbers = new ArrayList<>();
		for (char i = '1'; i <= '9'; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return numbers;
	}
	
	public char[] getUserNum() {
		System.out.print("3けたの数字を入力してください > ");
		String str = new java.util.Scanner(System.in).nextLine();
		char[] user = new char[3];
		user[0] = str.charAt(0);
		user[1] = str.charAt(1);
		user[2] = str.charAt(2);
		return user;
	}
	
	public int judge(char[] user, char[] com) {
		int score = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (user[i] == com[j]) {
					if (i == j) {
						score += 10;
					} else {
						score += 1;
					}
				}
			}
		}
		return score;
	}
}
