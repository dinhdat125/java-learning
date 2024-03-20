package baitap;

import java.util.Scanner;

public class Bai3 {
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập số nguyên N -> ");
		int number = ip.nextInt();
		
		long result = 1;
		for(int i = number; i > 0; i--)
			result *= i;
		
		System.out.println("Giai thừa của N = " + number + " -> " + result);
	}
}
