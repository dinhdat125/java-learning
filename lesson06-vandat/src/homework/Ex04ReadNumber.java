package homework;

import java.util.Scanner;

public class Ex04ReadNumber {

	private static Scanner ip = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = input();
		
		System.out.println("n = " + n + " -> " + readNumber(n));
		
	}
	
	private static int input() {
		int n;
		
		do {
			try {
				System.out.print("Nhập số nguyên N có 3 chữ số -> ");
				n = Integer.parseInt(ip.nextLine());
				if (n >= 0 && n < 1000)
					return n;
				else
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				System.out.println("Nhập sai ! Nhập lại !");
			}
			
		} while (true);
		
	}
	
	private static String readNumber(int n) {
		String result = readThousandsDigit(n) + readTensDigit(n) + readLastDigit(n);
		
		return result.trim();
	}
	
	private static String readThousandsDigit(int n) {
		String s = switch (n/100) {
		case 1 -> "Một trăm";
		case 2 -> "Hai trăm";
		case 3 -> "Ba trăm";
		case 4 -> "Bốn trăm";
		case 5 -> "Năm trăm";
		case 6 -> "Sáu trăm";
		case 7 -> "Bảy trăm";
		case 8 -> "Tám trăm";
		case 9 -> "Chín trăm";
		default -> "";
		};
		return s;
	}
	
	private static String readTensDigit(int n) {
		String s = switch ((n/10)%10) {
		case 1 -> " Mười";
		case 2 -> " Hai mươi";
		case 3 -> " Ba mươi";
		case 4 -> " Bốn mươi";
		case 5 -> " Năm mươi";
		case 6 -> " Sáu mươi";
		case 7 -> " Bảy mươi";
		case 8 -> " Tám mươi";
		case 9 -> " Chín mươi";
		default -> "";
		};
		
		if (n/100 > 0 && (n/10)%10 == 0 && n%100 != 0)
			s+= " Lẻ";
		
		return s;
	}
	
	private static String readLastDigit(int n) {
		String s = switch (n%10) {
		case 2 -> " Hai";
		case 3 -> " Ba";
		case 4 -> " Bốn";
		case 6 -> " Sáu";
		case 7 -> " Bảy";
		case 8 -> " Tám";
		case 9 -> " Chín";
		default -> "";
		};
		
		switch (n%10) {
		case 1:
			if ((n/10)%10 == 0 || (n/10)%10 == 1)
				s += " Một";
			else	s+= " Mốt";
			break;
		case 5:
			if ((n/10)%10 == 0)
				s += " Năm";
			else	s+= " Lăm";
			break;
		case 0:
			if (n/10 == 0)
				s += "Không";
		}
		
		return s;
	}
}
