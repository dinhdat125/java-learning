package homework;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		String name = input();
		
		System.out.println(name + " => " + nameFormat(name));
	}
	
	private static String nameFormat(String name) {
		String result = "";
		
		name = name.strip().replaceAll("\\s+", " ").toLowerCase();
		result += "" + Character.toUpperCase(name.charAt(0));
		for (int i = 1; i < name.length(); i++) {
			if (name.charAt(i) == ' ') {
				result += " " + Character.toUpperCase(name.charAt(i+1));
				i++;
			}
			else
				result += "" + name.charAt(i);
		}
		return result;
	}
	
	private static String input() {
		Scanner ip = new Scanner(System.in);
		String s = "";
		do {
			System.out.print("Nhập vào họ tên không dấu: ");
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
