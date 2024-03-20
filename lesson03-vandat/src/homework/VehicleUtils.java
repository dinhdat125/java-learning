package homework;

import java.util.Scanner;

public class VehicleUtils {

	public static double tax(Vehicle vehicle) {
		double tax;
		
		if (vehicle.getCylinderCapacity() < 100)	tax = vehicle.getPrice() * 0.01;
		else if (vehicle.getCylinderCapacity() < 200)	tax = vehicle.getPrice() * 0.03;
		else	tax = vehicle.getPrice() * 0.05;
		
		return tax;
	}

	public static void enter(Vehicle vehicle) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Tên chủ xe: ");
		String name = ip.nextLine();
		
		System.out.print("Loại xe: ");
		String type = ip.nextLine();
		
		System.out.print("Dung tích xe: ");
		int cc = ip.nextInt();
		
		System.out.print("Trị giá xe: ");
		double cost = ip.nextFloat();
		
		vehicle = new Vehicle(name, type, cc, cost);
	}

}
