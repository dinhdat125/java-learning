package homework;

import java.util.Scanner;

public class Ex06 {

	/*
	 * Cách 1 dùng suy luận logic
	 * vị trí K (K có 1 chữ số) -> K -> số K
	 * vị trí K (K có 2 chữ số):
	 * + 10-29: chẵn -> 1, lẻ -> 11-29 = 1-9
	 * + 30-49: chẵn -> 2, lẻ -> 31-49 = 1-9
	 * + ...
	 * + 90-109: chẵn -> 5 ==> vị trí 100 -> 5
	 */
	public static void main(String[] args) {
		System.out.println("Dãy vô hạn (1): 1234567891011121314........");
		int K = input();
		
		String s = "";
		for (int i = 1; s.length() <= K; i++) {
			// các số được viết vào chuỗi s đến vị trí thứ k là dừng
			s += String.valueOf(i);
		}
		
		System.out.println("Số nằm ở vị trí thứ " + K + " trong dãy (1) là: " + s.charAt(K-1));
	}
	
	private static int input() {
		Scanner ip = new Scanner(System.in);
		int n;
		do {
			try {
				System.out.print("Nhập số K -> ");
				n = Integer.parseInt(ip.nextLine());
				ip.close();
				return n;
			} catch (NumberFormatException e) {
				System.out.println("Nhập sai ! Nhập lại !");
			}
		} while (true);
	}
}
