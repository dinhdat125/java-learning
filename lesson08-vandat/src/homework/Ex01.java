package homework;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		String s = input();

		System.out.println("Chuỗi có các kí tự là:");
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + "_");
		}
		
		System.out.println("\nChuỗi có các từ là:");
		String[] words = s.strip().split("\\s+");
		for (String word:words)
			System.out.println(word);
		
		String s1 = "";
		for (int i = s.length() - 1; i >= 0; i--)
			s1 += s.charAt(i);
		System.out.print("Chuỗi đảo ngược -> " + s1);
		
		String s2 = "";
		for (int i = words.length - 1; i >= 0; i--)
			s2 += words[i] + " ";
		System.out.println("\nChuỗi đảo ngược theo từ -> " + s2.strip());
	}
	
	private static String input() {
		Scanner ip = new Scanner(System.in);
		String s = "";
		do {
			System.out.print("Nhập vào chuỗi kí tự tiếng việt có dấu và space: ");
			s = ip.nextLine();
			if (isValid(s)) {
				ip.close();
				return s;
			}
			else System.out.println("Nhập sai yêu cầu, vui lòng nhập lại !");
		} while (true);
	}
	
	private static boolean isValid(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isLetter(s.charAt(i)) && !Character.isWhitespace(s.charAt(i)))
				return false;
		}
		return true;
	}
}
