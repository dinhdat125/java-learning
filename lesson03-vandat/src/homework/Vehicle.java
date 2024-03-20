package homework;

public class Vehicle {
	private String vehicleOwner;
	private String nameVehicle;
	private int cylinderCapacity;
	private double price;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String vehicleOwner, String nameVehicle, int cylinderCapacity, double price) {
		this.vehicleOwner = vehicleOwner;
		this.nameVehicle = nameVehicle;
		this.cylinderCapacity = cylinderCapacity;
		this.price = price;
	}

	public String getVehicleOwner() {
		return vehicleOwner;
	}

	public void setVehicleOwner(String vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

	public String getNameVehicle() {
		return nameVehicle;
	}

	public void setNameVehicle(String nameVehicle) {
		this.nameVehicle = nameVehicle;
	}

	public int getCylinderCapacity() {
		return cylinderCapacity;
	}

	public void setCylinderCapacity(int cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
//		return "Vehicle [vehicleOwner=" + vehicleOwner + ", nameVehicle=" + nameVehicle + ", cylinderCapacity="
//				+ cylinderCapacity + ", price=" + price + "]";
		return vehicleOwner + "\t\t" + nameVehicle + "\t\t" + cylinderCapacity + "\t\t" + price;
	}
	
}
