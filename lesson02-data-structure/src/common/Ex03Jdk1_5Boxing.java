package common;

public class Ex03Jdk1_5Boxing {
	public static void main(String[] args) {
		
		//int có thể nhận giá trị từ Integer -> k cần ép kiểu
		//Integer có thể nhận giá trị từ int -> k cần ép kiểu
		
		int x1 = 2;
		int x2 = 8;
		
		Integer xo1 = 12;
		Integer xo2 = 18;
		
		xo1 = x1;
		x2 = xo2;
		
		//từ V1.0 đến V1.4 chưa xuất hiện khái niệm auto-boxing, auto-unboxing
		
		//từ V1.5 xuất hiện khái niệm
		
		//auto-boxing : java sẽ tự convert kiểu nguyên thủy sang kiểu đối tượng tương ứng
		//auto-unboxing :                       đối tượng 			  nguyên thủy
		
		Integer a = null;
		int b = a;
		System.out.println("b = " + b);
	
	}
}
