package baitap;

import java.util.Scanner;

public class Bai7 {

	public static void main(String[] args) {
		
		do {
			System.out.print("Nhập số nguyên N -> ");
			Scanner ip = new Scanner(System.in);
			String str = ip.nextLine();
			String result = "";
			
			if(isValidSelection(str)) {
				int number = Integer.parseInt(str);
				while ( number > 0 ) {
					int m = number % 2;
					result += m;
					number/=2;
				}
				// sử dụng KDL StringBuilder có hàm reverse để đảo ngược chuỗi kết quả
				System.out.println((new StringBuilder(result).reverse()));
			} 
			else System.out.println("Nhập sai ! Nhập lại !");
			
		} while (true);
	}
	
	private static boolean isValidSelection(String number) {
		if(number.matches("^\\d+$")) 		//kiểm tra chuỗi nhập vào có phải chuỗi số nguyên hay k
			if(Integer.parseInt(number) > 0) return true;
		
		return false;
	}
}
