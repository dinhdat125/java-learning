package view.lambda.expression;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class Ex01LambdaTests {

	public static void main(String[] args) {
		/*
		 1. () -> {} 
		  --> đoán được công thức của hàm trừu tượng
		  + số lượng tham số trong hàm trừu tượng của Function Interface
		  + kiểu trả về của hàm trừu tượng đó
		  + tên của FI có sẵn trong Java
		  
		 2. () -> "Raoul"
		  + ko có tham số truyền vào
		  + trả về T
		 
		 4. (Integer i) -> {return "Alan" + i;}
		  + có 1 tham số truyền vào kiểu T
		  + trả về kiểu R
		 */
		
		Runnable runnable = () -> {};
		runnable.run();
		
		Callable<String> callable = () -> "Raoul";
		try {
			System.out.println("callable -> " + callable.call());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Function<Integer, String> function = (Integer i) -> "Alan" + i;
		System.out.println("function -> " + function.apply(3));

		// Comparator<T>    : (T, T) -> int
		// Comparable<T>    : T      -> int
		// Predicate<T>     : T      -> boolean
		// Consumer<T>      : T      -> void
		// Function<T, R>   : T      -> R
		// UnaryOperator<T> : T      -> T
		// BinaryOperator<T>: (T, T) -> T
		// Supplier<T>      : ()     -> T
		// Runnable         : ()     -> void
		// Callable<T>      : () throws Exception -> T
		
		// BiPredicate<L, R>   : (L, R) -> boolean
		// BiConsumer<T, U>    : (T, U) -> void
		// BiFunction<T, U, R> : (T, U) -> R
	}
}
