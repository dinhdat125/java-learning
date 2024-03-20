package baitap;

import java.util.Random;

public class Bai4 {
	public static void main(String[] args) {
		
		Random rd = new Random();
		int a = rd.nextInt(10,21);
		int b = rd.nextInt(10,21);
		int c = rd.nextInt(10,21);
		int d = rd.nextInt(10,21);
		
		long sum = Factorial(a) + Factorial(b) + Factorial(c) + Factorial(d); 
		
		System.out.println("4 số ngẫu nhiên từ [10,20] là: "+a+", "+b+", "+c+", "+d);
		System.out.println("Tổng -> " + sum);
	}

	private static long Factorial(int number) {
		long result = 1;
		for(int i = number; i > 0; i--)
			result *= i;
		return result;
	}
}
