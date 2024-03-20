package view;

import bean.Car;

public class Ex01CarDemo {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.setId("C1");
		c1.setModel("MG5");
		c1.setColor("Yellow");
		c1.setSalePrice(500d);
		
		Car c2 = new Car("C2",  "Black", 800d);
		Car c3 = new Car("C3",  "White", 700d);
		Car c4 = new Car("C4",  "Red", 750d);
		
		/*
		 	1.phân biệt khi nào sử dụng constructor và getter setter
		 	-> khi nào ra 1 đt (tạo 1 ô nhớ mới ở HEAD): constructor
		 	-> khi muốn cập nhật giá trị: setter
		 	-> khi muốn lất giá trị của từng thuộc tính: getter
		 	
		 	2.tại sao phải khai báo thuộc tính của class là private, rồi sau đó dùng getter setter
		 		để truy caajpmaf k khai báo thẳng thuộc tính là public để code ngăn gọn 
		 		+ public 
		 			-> được phép truy cập từ bất kỳ class nào -> giống FOP
		 			-> k quản lý dữ liệu riêng của từng đt (class)
		 		+ private
		 			-> đc phép truy cập từ class hiện tại
		 			-> bên ngoài chỉ có thể truy cập thông qua getter, setter để thao tác với giá trị
		 			
		 			+ bên ngoài k thể thay đổi cấu trúc dữ liệu của thuộc tính bên trong class
		 			+ bên ngoài nên truy cập tăng/giảm/thay đổi giá trị của thuộc tính chứ k nên biết
		 			chính xác giá trị nguồn gốc của thuộc tính đó ntn
		 	
		 */
		
		
		System.out.println("c1 -> " + c1);		
		System.out.println("c2 -> " + c2);
		System.out.println("c3 -> " + c3);
		System.out.println("c4 -> " + c4);

	}
}
