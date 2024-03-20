package homework;

import java.util.Scanner;

public class Ex04 {

	private static Scanner ip = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = input("N");
		int m = input("M");
		
		System.out.println("Các ước nguyên tố của " + n + " -> " + primeDivisor(n));
		System.out.println("Các ước nguyên tố của " + m + " -> " + primeDivisor(m));
		if (primeDivisor(n).equals(primeDivisor(m)))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	// liệt kê các ước nguyên tố
	private static String primeDivisor(int n) {
		String primeDivisor = "";
		for (int i = 2; i <= n/2; i++ ) {
			if (isPrime(i) && n % i == 0) {
				primeDivisor += String.valueOf(i) + " ";
			}
		}
		return primeDivisor.strip();
	}
	
	private static boolean isPrime(int n) {
		if (n < 2) {
	        return false;
	    }
	    for (int i = 2; i * i <= n; i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	private static int input(String s) {
		int n;
		
		do {
			try {
				System.out.print("Nhập số tự nhiên " + s + " (>= 2) -> ");
				n = Integer.parseInt(ip.nextLine());
				if (n >= 2)
					return n;
				else
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				System.out.println("Nhập sai ! Nhập lại !");
			}
		} while (true);
		
	}
}
