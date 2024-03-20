package baitap;

import java.util.Scanner;

public class Bai6 {
	public static void main(String[] args) {
		
		System.out.println("Nhập 3 số nguyên dương N nhỏ hơn 20");
		System.out.print("a = ");
		int a = enterNumber();
		System.out.print("b = ");
		int b = enterNumber();
		System.out.print("c = ");
		int c = enterNumber();
//		System.out.println(a+" "+b+" "+c);
	
		int max = a > b ? a : b;
		max = max > c ? max : c;
		
		int min = a < b ? a : b;
		min = min < c ? min : c;
		
		System.out.println("Số lớn nhất là "+max);
		System.out.println("Số nhỏ nhất là "+min);

	}
	
	private static boolean isValidSelection(String number) {
		if(number.matches("^\\d+$")) 		//kiểm tra chuỗi nhập vào có phải chuỗi số nguyên hay k
			if(Integer.parseInt(number) >= 0 && Integer.parseInt(number) < 20) return true;
			//kiểm tra số nguyên dương có tối thiểu 2 chữ số hay k
		
		return false;
	}
	
	private static int enterNumber() {
		do {
			Scanner ip = new Scanner(System.in);
			String number = ip.nextLine();
			
			if(isValidSelection(number)) {
				return Integer.parseInt(number);
			} 
			else System.out.println("Nhập sai ! Nhập lại !");
			
		} while (true);
	}
}
