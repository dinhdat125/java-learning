package homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Ex01EquationTurnsOne {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		double a, b;
		do {
			try {
				System.out.print("Nhập hệ số a = ");
				a = Double.parseDouble(ip.nextLine());
				if (a == 0) {
					throw new ArithmeticException("Hệ số a phải khác 0");
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Nhập sai hệ số a, vui lòng nhập lại");
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage() + ", vui lòng nhập lại");
			}
		} while (true);
		
		do {
			try {
				System.out.print("Nhập hệ số b = ");
				b = Double.parseDouble(ip.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Nhập sai hệ số b, vui lòng nhập lại");
			}
		} while (true);

		System.out.println("Kết quả là -> " + BigDecimal.valueOf(-b/a)
												.setScale(3, RoundingMode.HALF_UP));
		
		ip.close();
	}
	
}
