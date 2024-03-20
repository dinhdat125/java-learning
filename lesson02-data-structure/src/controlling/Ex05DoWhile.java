package controlling;

import java.util.Scanner;

public class Ex05DoWhile {
	public static void main(String[] args) {
		//lựa chọn chức năng : 1->A	2->B	3->C	4->thoát
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Các chức năng\n"
				+ "	1.Chức năng A\n"
				+ "	2.Chức năng B\n"
				+ "	3.Chức năng C\n"
				+ "	4.Thoát\n");
		
		do {
			System.out.print("Nhập lựa chọn -> ");
			String option = ip.nextLine();
			
			if(isValidSelection(option)) {
				switch (option) {
					case "1":
						System.out.println("Thực hiện chức năng A ...\n");
						break;
					case "2":
						System.out.println("Thực hiện chức năng B ...\n");
						break;
					case "3":
						System.out.println("Thực hiện chức năng C ...\n");
						break;
					case "4":
						System.out.println("Thoát chương trình ...\n");
						System.exit(0);
				}
			} else System.out.println("Nhập sai ! Nhập lại !");
			
		} while (true);
	}
	
	private static boolean isValidSelection(String option) {
		if(option.matches("^\\d+$")) 		//kiểm tra chuỗi nhập vào có phải chuỗi số nguyên hay k
			if(Integer.parseInt(option) > 0 && Integer.parseInt(option) < 5) return true;
		
		return false;
		
//		return option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4");
	}
}
