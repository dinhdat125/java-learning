package bean;
//các class tạo ra để khai báo KDL đối tượng vd như Item, Car, ...
//Spring FW : 

public class Car {
	
	//sẽ được cấp phát, gán giá trị khi tạo ra đt mới
	//mỗi đt sẽ lưu trữ thông tin riêng của các thuộc tính
	
	//oop: mỗi đt sẽ quản lý thông tin thuộc tính của riêng nó
	//access modifier: private
	
	//thuộc tính
	//static: thuộc phạm vi của class
	//		: các đối tượng của class sẽ mang cùng giá trị static
	//		: gọi Class.
	//		:	  Object. (k khuyến khích)
	
	//non-static: thuộc phạm vi của object
	//			: mỗi thuộc
	private String id;
	public static String model;
	private String color;
	private double salePrice;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String id, String color, double salePrice) {
		this.id = id;
		this.color = color;
		this.salePrice = salePrice;
	}

	//getter, setter
	//để các class bên ngoài có thể truy cập, thay đổi giá trị của các thuộc tính private bên trong class
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
		
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", color=" + color + ", salePrice=" + salePrice + "]";
	}
	
	
}
