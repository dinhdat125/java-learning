package homework;

import java.util.Scanner;

public class Ex03CheckEmailFormat {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		String email = "";
		do {
			System.out.print("Enter email address: ");
			email = ip.nextLine();
			try {
				if (checkEmailByRegex(email)) {
					System.out.println("Success ! Email -> " + email);
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Email address is not valid. " + e.getMessage()
									+ "\nPlease re-enter !\n");
			}
		} while (true);
		
		ip.close();
	}
	
	/*
	private static boolean checkEmail(String email) {
		if (!email.endsWith("@mail.com"))
			throw new IllegalArgumentException("Invalid email domain");
		
		String[] formats = email.split("@");
		String prefix = formats[0];
		//String domain = formats[1];
		
		if (prefix.charAt(0) == '.' || prefix.charAt(0) == '_' || prefix.charAt(0) == '-')
			throw new IllegalArgumentException("Invalid email prefix (an underscore, period or dash"
										+ " cannot be at the beginning)");
		for (int i = 1; i < prefix.length(); i++) 
			if (prefix.charAt(i) == '.' || prefix.charAt(i) == '_' || prefix.charAt(i) == '-')
				if (i == prefix.length() - 1 || !Character.isLetterOrDigit(prefix.charAt(i + 1)))
					//nếu kí tự thứ i là ( .-_ ) + kí tự thứ i + 1 k phải chữ hoặc số thì lỗi
					//							 + cũng là kí tự cuối của prefix thì lỗi ngay
					throw new IllegalArgumentException("Invalid email prefix (an underscore, period or dash"
												+ " must be followed by one or more letter or number)");
		
		return true;
	}
	*/
	
	private static boolean checkEmailByRegex(String email) {
		if (!email.endsWith("@mail.com"))
			throw new IllegalArgumentException("Invalid email domain");
		
		String[] formats = email.split("@");
		String prefix = formats[0];
		//String domain = formats[1];
		
		if (!prefix.matches("^[a-z0-9]+([._-]?[a-z0-9]+)+$"))
			throw new IllegalArgumentException("Invalid email prefix");
		
		return true;
	}
}
