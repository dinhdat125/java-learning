package ex1to4;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int count = 0;
		
		do {
			System.out.print("Nhập số thực -> ");
			
			try {
				Float number = Float.parseFloat(ip.nextLine());
				if (number % 1.0 == 0)
					throw new NumberFormatException();
				System.out.println(number + " -> " + getMinFract(number));
			} catch (NumberFormatException e) {
				count++;
				if(count == 3)	System.out.println("Nhập sai quá 3 lần ! Thoát chương trình.");
				else	System.out.println("Nhập sai ! Nhập lại !");
			}			
		} while (count < 3);
		
		ip.close();
	}
	
	/*
	private static boolean isValidSelection(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit(number.charAt(i)) && number.charAt(i) != '.')
				return false;
			if (number.charAt(i) == '.') {
				for (int j = i + 1; j < number.length(); j++) {
					if (number.charAt(j) < '0' || number.charAt(j) > '9') {
						return false;
					}
				}
			}
		}

		
		return true;
	}
	*/
	
	private static String getMinFract(float number) {
		int mauSo = 1;
		while (number != (int) number) {
			number *= 10;
			mauSo *= 10;
		}
		int ucln = ucln((int) number, mauSo);
		int tuSo = (int) number / ucln;
		mauSo /= ucln;
		
		return tuSo + "/" + mauSo;
	}
	
	public static int ucln(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return ucln(b, a % b);
		}
	}
}
