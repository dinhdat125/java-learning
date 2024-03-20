package view;

import bean.Tuple;

public class Ex03MethodStaticDemo {
	/*
	 * đặt static ở đâu
	 * attribute
	 	-> thuộc tính mang giá trị dùng chung cho tất cả các đối tượng của class -> static
	 		k phụ thuộc vào đối tượng đang gọi
	 	-> thuộc tính mà mỗi đối tượng lưu trữ/quản lý riêng 1 vùng nhớ			 -> non-static
	 		phụ thuộc vào đối tượng đang gọi
	 * method
	 	-> k phụ thuộc vào đối tượng đang gọi -> static
	 	-> phụ thuộc vào đối tượng đang gọi -> non-static
	 * class
		non-static: thuộc phạm vi của đối tượng
					phải có đối tượng mới gọi được
		static	  : thuộc phạm vi của lớp ( class )
					nên gọi từ class -> class.
					có thể lấy đối tượng gọi -> warning
	 */
	
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		
//		Ex03MethodStaticDemo ms1 = new Ex03MethodStaticDemo();
		System.out.println("ms1 -> " + Ex03MethodStaticDemo.sum(m,n));
		
		Tuple tuple1 = new Tuple(3,2);
		System.out.println("tuple1 sum -> " + tuple1.sum());
		
		Tuple tuple2 = new Tuple(3,7);
		System.out.println("tuple1 sum -> " + tuple2.sum());
	}
	
	//hàm sum chỉ thuộc phụ vào tham số truyền vào a , b
	//k phụ thuộc vào đối tượng đang gọi -> static
	private static int sum(int a, int b) {
		return a + b;
	}
}
