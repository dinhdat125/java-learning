package view.inheritance.iinterface;

public class InheritanceInterfaceDemo {

	public static void main(String[] args) {
		
		// anonymous class
		Shape sh1 = new Shape() {
			
			@Override
			public void paint() {
				System.out.println("Circle -> paint");
			}
			
			@Override
			public void cals() {
				System.out.println("Circle -> cals");				
			}
		};
		sh1.paint();
		sh1.cals();
		
		// external class
		Shape sh2 = new Circle();
		sh2.paint();
		sh2.cals();
		
		// anonymous function
		
		// để tạo 1 đối tượng cho biến KDL interface
		// dùng external class, anonymous class -> có thể có 1 hoặc nhiều hàm trừu tượng
		// dùng anonymous function -> có duy nhất 1 hàm trừu tượng
	}
}
