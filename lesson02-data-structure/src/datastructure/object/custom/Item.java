package datastructure.object.custom;

/**
 * Tạo ra KDLđối tượng
 * KDL tên là Item
 * Bao gồm 3 thông tin: Item(id, name, price)
 */

public class Item {
	//attributes: thuộc tính
	//khi khởi tạo/gán giá trị cho biến kiểu Item
	//thì ô nhớ mà biến đó trỏ đến phải luôn có 3 thông tin của thuộc tính
	public int id;
	public char name;
	public double price;
	
	//constructor
	// no return type 
	public Item() {
		
	}
	
	public Item(int id, char name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.id + "," + this.name + "," + this.price;
	}
}
