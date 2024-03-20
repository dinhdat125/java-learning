package homework;

import java.util.Scanner;

public class Ex02CheckPasswordShowFullError {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		String password = "";
		do {
			System.out.print("Enter password: ");
			password = ip.nextLine();
			
			boolean[] check = new boolean[6];	// full value in check[] -> false
			checkPassword(password, check);
			
			if (check[0]) {
				break;
			} else {
				System.out.println("Entered the wrong request:\n" + missingRequirements(check) +
						"Please re-enter !\n");
			}
		} while (true);
		
		System.out.println("Account registration successful ! Password -> " + password);		
		
		ip.close();
	}
	
	private static void checkPassword(String password, boolean[] check) {

		if (password.matches("^.{8,256}$"))
			check[1] = true;
		if (password.matches("^.*[a-z]+.*$"))
			check[2] = true;
		if (password.matches("^.*[A-Z]+.*$"))
			check[3] = true;
		if (password.matches("^.*[0-9]+.*$"))
			check[4] = true;
		if (password.matches("^.*[!@#$%&*()_+=,.:;/^|<>?{}\\[\\]~-]+.*$"))
			check[5] = true;
		check[0] = true;
		for (int i = 1; i < 6; i++) {
			if (check[i] == false) {
				check[0] = false;
				break;
			}
		}
	}
	
	private static String missingRequirements(boolean[] check) {
		String result = "";
		for (int i = 1; i < 6; i++) {
			if (check[i] == false) {
				result += switch (i) {
				case 1 -> "At least 8 and most 256 characters\n";
				case 2 -> "At least 1 lowercase alphabetic character\n";
				case 3 -> "At least 1 uppercase alphabetic character\n";
				case 4 -> "At least 1 number\n";
				case 5 -> "At least 1 special character\n";
				default -> "";
				};
			}
		}
		return result;
	}
}
