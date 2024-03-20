package view.lambda.expression;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import bean.Apple;
import model.DataModel;

import static java.util.Comparator.*;

public class Ex03MethodReference {

	public static void main(String[] args) {
		// implementation class
		
		// anonymous class
		
		// anonymous function(lambda expression)
		Predicate<Apple> predicate = apple -> apple.getExpiredDate().isBefore(LocalDate.now());
		BinaryOperator<Integer> maxOperator = (a, b) -> a > b ? a : b;
		BinaryOperator<Integer> sumOperator = (a, b) -> a + b;
		
		Function<Apple, Integer> function = (Apple apple) -> apple.getId();
		Consumer<Apple> consumer = (Apple apple) -> System.out.println(apple);
		
		// method reference
		// -> using static method(apply for all lambda expression)
		// nên dùng khi
		// lambda có dạng giống 1 static method đã tồn tại/có sẵn trong Java/Custom
		// lambda có body dài và được gọi/sử dụng ở nhiều chỗ(class)
		predicate = Apple::testExpDate;
		maxOperator = Ex03MethodReference::max;
		maxOperator = Integer::max;
		sumOperator = Integer::sum;
		
		List<Apple> inventory = DataModel.mockApples();
		List<Apple> expiredApples = filterApples(inventory, predicate);
		// Consumer<T>
		expiredApples.forEach(expiredApple -> System.out.println(expiredApple));
		
		List<Integer> numbers = List.of(2,5,7,3,5,1);
		int max = process(Integer.MIN_VALUE, numbers, maxOperator);
		System.out.println("max -> " + max);
		int sum = process(0, numbers, sumOperator);
		System.out.println("sum -> " + sum);

		// -> using non static method(few special cases)
		function = Apple::getId;
		consumer = System.out::println;
		
		// sort list of by id descending
		inventory.sort(comparing(function, reverseOrder()));
		inventory.forEach(consumer);
		
	}
	
	private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate){
		var result = new ArrayList<Apple>();
		for (Apple apple: inventory)
			if (predicate.test(apple))
				result.add(apple);
		return result;
	}
	
	private static Integer process(Integer initial, List<Integer> numbers, BinaryOperator<Integer> operator) {
		Integer result = initial;
		for (Integer number: numbers)
			result = operator.apply(result, number);
		return result;
	}
	
	private static Integer max(int a, int b) {
		return a > b ? a : b;
	}
}
