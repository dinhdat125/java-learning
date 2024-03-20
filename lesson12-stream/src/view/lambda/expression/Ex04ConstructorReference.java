package view.lambda.expression;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import bean.Tuple;

public class Ex04ConstructorReference {

	public static void main(String[] args) {
		/*
		 Anonymous function(lambda expression)
		 --> chuyển thành method reference
		 ->  với bất kỳ biểu thức lambda nào có
		 	+ số lượng tham số bất kỳ
		 	+ kiểu trả về bất kỳ
		 --> chuyển thành constructor reference
		 ->  lambda phải thỏa mãn yêu cầu
		 	+ số lượng tham số bất kỳ
		 	+ kiểu trả về là KDL đối tượng và được tạo thông qua constructor
		 */
		
		// lambda expression
		// Supplier<Tuple> s1 = () -> new Tuple();
		// BiFunction<Integer, Integer, Tuple> b1 = (l, r) -> new Tuple(l, r);
		
		// method reference
		Supplier<Tuple> s1 = Ex04ConstructorReference::init;
		
		// constructor reference
		// Việc new mà chọn hàm khởi tạo nào --> phụ thuộc vào kiểu functional interface
		s1 = Tuple::new;
		BiFunction<Integer, Integer, Tuple> b1 = Tuple::new;
		
		Tuple tupleS = s1.get();
		Tuple tupleB = b1.apply(5, 6);
		
		System.out.println("tupleS --> " + tupleS);
		System.out.println("tupleB --> " + tupleB);
	}
	
	private static Tuple init() {
		return new Tuple();
	}
}
