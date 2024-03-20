package view;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Enter username: ");
		String username = ip.nextLine();
		
		String password = "";
		do {
			System.out.print("Enter password: ");
			password = ip.nextLine();
			try {
				if (checkPassword(password, username)) {
					System.out.println("Account registration successful ! Password -> " + password);
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Entered the wrong request -> " + e.getMessage());
				System.out.println("Password Requirements:");
				System.out.println("1. At least 8 characters\n2. At least 1 number, 1 uppercase alphabetic character"
						+ " and 1 special character (~!@#$%^&*)\n3. Must not overlap more than 3 characters with the username");
				System.out.println("Please re-enter\n");
			}
		} while (true);
		
		ip.close();
	}
	
	private static boolean checkPassword(String password, String username) {
		if (!password.matches("^.{8,}$"))
			throw new IllegalArgumentException("At least 8 characters");
		if (!password.matches("^.*[0-9]+.*$"))
			throw new IllegalArgumentException("At least 1 number");
		if (!password.matches("^.*[A-Z]+.*$"))
			throw new IllegalArgumentException("At least 1 uppercase alphabetic character");
		if (!password.matches("^.*[~!@#$%^&*]+.*$"))
			throw new IllegalArgumentException("At least 1 special character (~!@#$%^&*)");
		if (isMatches(password, username))
			throw new IllegalArgumentException("Must not overlap more than 3 characters with the username");
		return true;
	}
	
	private static boolean isMatches(String pass, String user) {
		// vì kiểm tra kí tự trùng k cần phân biệt hoa/thường, nên chuyển cả 2 về chữ thường (hoặc hoa) để ss
		pass = pass.toLowerCase();
		user = user.toLowerCase();
		String duplicateCharacters = "";	//chuỗi chứa các ký tự trong password bị trùng với ký tự trong username
		int count = 0;
		for (int i = 0; i < pass.length(); i++) {
			for (int j = 0; j < user.length(); j++) {
				if (pass.charAt(i) == user.charAt(j) && !duplicateCharacters.contains(pass.charAt(i) + "")) {
					count++;
					if (count > 3)
						return true;
					duplicateCharacters += pass.charAt(i) + "";
					break;
				}
			}
		}
		return false;
	}
}
