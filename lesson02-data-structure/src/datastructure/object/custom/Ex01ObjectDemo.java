package datastructure.object.custom;

public class Ex01ObjectDemo {
	public static void main(String[] args) {
		//khai báo và khởi tạo giá trị cho biến thuộc KDL nguyên thủy
		int a=12;
		char b='^';
		/*
			khai báo và khởi tạo giá trị cho biến thuộc KDL đối tượng
			new Item () -> gọi hàm khởi tạo mặc định của class(KDL) Item
			
		 */
		Item i1 = new Item();
		i1.id = a;
		i1.name = b;
		i1.price = 11d;
		System.out.println("i1 address 1st "+System.identityHashCode(i1));
		
		//tạo ô nhớ mới và gán địa chỉ của ô nhớ mới cho i1
		i1 = new Item(); // H2 : i1 trỏ đến H2
		System.out.println("i1 address 2nd "+System.identityHashCode(i1));
		
		Item i2 = new Item();
		i2.id = 2;
		i2.name = 'C';
		i2.price = 22d;
		
		//khởi tạo ô nhớ và gán giá trị trực tiếp cho ô nhớ đó
		//hàm khởi tạo có tham số
		Item i4 = new Item(4,'E',44d);
		
		//java có class gọi là cha của tất cả các KDL đt --> Object
		//Object có 1 số hàm : toString, hashcode, equals
		
		//khi in 1 biến KDL đối tượng thì mặc định gọi hàm toString() có sẵn trong KDL của biến đó
		//in i1 -> t1.toString()
		//khi in ra biến KDL đt -> in ra giá trị tất cả các thuộc tính của ô nhớ mà biến đó đang trỏ đến
		
		System.out.println("i1 1st --> "+i1);
//		System.out.println("i1 2nd --> "+i1.toString());
//		System.out.println("i1 3rd --> "+i1.id+","+i1.name+","+i1.price);
		System.out.println("i2 --> "+i2);
		System.out.println("i4 --> "+i4);




	}
}
