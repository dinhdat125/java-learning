package ex1to4;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập số kiểm tra: ");
		int n = ip.nextInt();
		System.out.println(n + " -> " + isSpecialNumber(n));
		ip.close();
	}
	
	private static boolean isSpecialNumber(int number) {
		int check = 0;
		for (int i = 1; i < number; i++) {
			check += i;
			if (check == number)
				return true;
		}
		return false;
	}
}
