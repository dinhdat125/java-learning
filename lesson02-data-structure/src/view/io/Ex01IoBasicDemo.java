package view.io;

import java.util.Scanner;

public class Ex01IoBasicDemo {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhap id: ");
		String id = ip.nextLine();
		
		System.out.print("Nhap sdt: ");
		int sdt = Integer.parseInt(ip.nextLine());
		
		System.out.println("id -> " + id);
		System.out.println("sdt -> " + sdt);

		
		

		ip.close();
	}
}
