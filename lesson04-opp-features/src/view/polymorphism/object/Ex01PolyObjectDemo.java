package view.polymorphism.object;

public class Ex01PolyObjectDemo {

	public static void main(String[] args) {
		//Shape
		Shape shape = new Shape();
		shape.paint();
		shape.cals();
		
		//Rectangle
		Rectangle rectangle = new Rectangle();
		rectangle.paint();
		rectangle.cals();
		
		//Square
		Square square = new Square();
		square.paint();
		square.cals();
		
		//Polymorphism with Object

		//	s1
		//compile: Shape
		//runtime: Square
		Shape s1 = new Square();
		s1.paint();
		s1.cals();
		
		Shape s2 = new Rectangle();
		s2.paint();
		s2.cals();
		
		s2 = s1;
		
		//cho ds các hình ( vuông, chữ nhật, tròn, ... )
		Shape[] shapes = {square, rectangle};
		
		/*
		 Câu hỏi
		 1. Parent p = new Child();
		 	có thể lấy Child c = new Parent() được k? vì sao?
		 	-> k, vì khi biến thuộc Child gọi hàm tự tạo ra, lúc runtime k thể tim thấy được trong
		 		đối tượng KDL cha -> failed first
		 	Biến KDL cha có thể nhận giá trị KDL chính nó hoặc KDL con
		 2. Tại sao k khai báo trực tiếp
		 		+ Parent p = new Parent();
		 		+ Child c = new Child();
		 	mà phải sử dụng da hình trong đối tượng?
		 		+ Parent p1 = new Parent();
		 		+ Parent p2 = new Parent();
		 	->	- dễ dàng ép kiểu qua về giữa các biến trong phạm vi KDL cha con ( dòng 34 )
		 		- hỗ trợ tạo danh sách (mảng) các phần tử trong phạm vi cha con ( dòng 36 )
		 		- hỗ trợ tạo hàm có KDL cha(chung) có thể truyền tham số KDL con
		 			log(shape);
		 			log(retangle);
		 			log(square);
		 			
		 			void log(Shape shape){
		 			
		 			}
		 		- hỗ trợ factory pattern
		 */
		shape = rectangle;
		// rectangle = shape;	error
		
	}
}
