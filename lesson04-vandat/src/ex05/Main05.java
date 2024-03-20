package ex05;

import java.util.Scanner;

public class Main05 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập số lượng n phần tử trong mảng -> ");
		int n = ip.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + i + " : ");
			arr[i] = ip.nextInt();
			System.out.println("================ => level: " + level(arr[i]));
		}

		// Bubble Sort
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (level(arr[j]) > level(arr[j+1])) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.print("Kết quả sau khi đã sắp xếp: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

	}
	
	public static int level(int number) {
		int level = 0;
		for (int i = 1; i <= number; i++)
			if (number % i == 0)
				level++;
		return level;
	}
}
