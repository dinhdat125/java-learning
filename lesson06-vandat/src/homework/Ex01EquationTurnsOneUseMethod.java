package homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Ex01EquationTurnsOneUseMethod {


	private static Scanner ip = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			System.out.println("Giai phuong trinh ax + b = 0");
			System.out.println("Kết quả x = " + equation());
		} catch (NumberFormatException | ArithmeticException e) {
			e.printStackTrace();
		}
	}
	
	private static BigDecimal equation() {
		int a = input("hệ số a", 0);
		int b = input("hệ số b", null);
		return BigDecimal.valueOf((double)-b/a).setScale(3, RoundingMode.HALF_UP);
	}
	
	private static int input(String message, Integer number) {
		int n;
		do {
			try {
				System.out.print("Nhập " + message + " : ");
				n = Integer.parseInt(ip.nextLine());
				if (number != null && n == number)
					throw new ArithmeticException();
				return n;
			} catch (NumberFormatException | ArithmeticException e) {
				System.out.println("Nhập sai " + message + ", vui lòng nhập lại");
			}
		} while (true);
	}
}
