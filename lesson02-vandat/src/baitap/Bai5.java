package baitap;

import java.util.Scanner;

public class Bai5 {
	public static void main(String[] args) {
		
		do {
			System.out.print("Nhập số nguyên N -> ");
			Scanner ip = new Scanner(System.in);
			String number = ip.nextLine();
			
			if(isValidSelection(number)) {
				if (isSymmetricalNumber(Integer.parseInt(number)))
					System.out.println("N = " + number + " là số đối xứng!");
				else	System.out.println("N = " + number + " là số không đối xứng!");
			} 
			else System.out.println("Nhập sai ! Nhập lại !");
			
		} while (true);
	}
	
	private static boolean isValidSelection(String number) {
		if(number.matches("^\\d+$")) 		//kiểm tra chuỗi nhập vào có phải chuỗi số nguyên hay k
			if(Integer.parseInt(number) > 99) return true;
			//kiểm tra số nguyên dương có tối thiểu 2 chữ số hay k
		
		return false;
	}
	
	private static boolean isSymmetricalNumber(int number) {
		int temp = number;
		int checknumber = 0;
		while(temp != 0) {
			checknumber = checknumber * 10 + temp % 10;
			temp/=10;
		}
		if (checknumber == number) return true;
		return false;
	}
}
