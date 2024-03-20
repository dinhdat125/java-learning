package homework;

import java.util.Scanner;

public class Ex02CheckPassword {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		String password = "";
		do {
			System.out.print("Enter password: ");
			password = ip.nextLine();
			try {
				if (checkPassword(password)) {
					System.out.println("Account registration successful ! Password -> " + password);
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Entered the wrong request -> " + e.getMessage());
				System.out.println("Please re-enter\n");
			}
		} while (true);
		
		ip.close();
	}
	
	private static boolean checkPassword(String password) {
		if (!password.matches("^.{8,256}$"))
			throw new IllegalArgumentException("At least 8 and most 256 characters");
		if (!password.matches("^.*[a-z]+.*$"))
			throw new IllegalArgumentException("At least 1 lowercase alphabetic character");
		if (!password.matches("^.*[A-Z]+.*$"))
			throw new IllegalArgumentException("At least 1 uppercase alphabetic character");
		if (!password.matches("^.*[0-9]+.*$"))
			throw new IllegalArgumentException("At least 1 number");
		if (!password.matches("^.*[!@#$%&*()_+=,.:;/^|<>?{}\\[\\]~-]+.*$"))
			throw new IllegalArgumentException("At least 1 special character");
		
		return true;
	}
}
