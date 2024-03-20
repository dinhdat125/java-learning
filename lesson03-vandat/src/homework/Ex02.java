package homework;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập số lượng xe cần theo dõi -> ");
		int quantity = ip.nextInt();
		
		Vehicle[] vehicles = new Vehicle[quantity];
		
		for (int i = 0; i < quantity; i++) {

			System.out.println("Nhập thông tin xe thứ " + (i + 1));
			ip.nextLine();
			System.out.print("Tên chủ xe: ");
			String name = ip.nextLine();
		
			System.out.print("Loại xe: ");
			String type = ip.nextLine();
			
			System.out.print("Dung tích xe: ");
			int cc = ip.nextInt();
			
			System.out.print("Trị giá xe: ");
			double cost = ip.nextFloat();
			
			vehicles[i] = new Vehicle(name, type, cc, cost);
		}

		System.out.println("Tên chủ xe\t\tLoại xe\t\t\tDung tích\tTrị giá\t\tThuế phải nộp");
		
		for (int i = 0; i < quantity; i++)
			System.out.println(vehicles[i].toString() + "\t\t" + VehicleUtils.tax(vehicles[i]));

	}
}
