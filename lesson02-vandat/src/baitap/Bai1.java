package baitap;

import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		int count = 0;
		
		do {
			System.out.print("Nhập số nguyên N -> ");
			String number = ip.nextLine();
			
			if(isValidSelection(number)) {
				System.out.println("N = " + number + " -> " + isMultiplesOf2(Integer.parseInt(number)));
			} 
			else {
				count++;
				if(count == 5)	System.out.println("Nhập sai quá 5 lần ! Thoát chương trình.");
				else	System.out.println("Nhập sai ! Nhập lại !");
			}
			
		} while (count < 5);
	}
	
	private static boolean isValidSelection(String number) {
		if(number.matches("^\\d+$")) 		//kiểm tra chuỗi nhập vào có phải chuỗi số nguyên hay k
			if(Integer.parseInt(number) > 0) return true;
		
		return false;
	}
	
	private static boolean isMultiplesOf2(int number) {
		if(number % 2 == 0) return true;
		return false;
	}
}
