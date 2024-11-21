package ex2;

public class Main {

	public static void main(String[] args) {
		// email("業務連絡", "aaa@bbb.cc", "寒くなりましたね。");
		email("aaa@bbb.cc", "寒くなりましたね。");
	}

	public static void email(String title, String address, String text) {
		System.out.println(address + "に、以下のメールを送信しました。");
		System.out.println("件名: " + title);
		System.out.println("本文: " + text);
	}

	public static void email(String address, String text) {
		email("無題", address, text);
	}
	
	/*
	public static void email(String address, String text) {
		System.out.println(address + "に、以下のメールを送信しました。");
		System.out.println("件名: 無題");
		System.out.println("本文: " + text);
		
	}
	*/
}
