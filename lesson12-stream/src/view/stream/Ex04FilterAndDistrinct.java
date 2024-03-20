package view.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import bean.Apple;
import model.DataModel;

import static utils.StreamUtils.generate;

public class Ex04FilterAndDistrinct {

	public static void main(String[] args) {

		// Question 1: filter all odd numbers from a list and makes sure that there are no duplicates

		// using list
		var numbers = List.of(1, 2, 3, 4, 2, 4, 6, 3, 4, 5, 3, 5, 1);

		// distinct + toList = toSet
		var oddNumbers = numbers.stream()
				.filter(nb -> nb % 2 != 0)
				.distinct()
				.collect(Collectors.toList());
		generate("1. Odd Numbers", oddNumbers);

		// using array
		int[] digits = { 4, 5, 6, 7, 3, 5, 7, 8, 3, 2, 7 };
		
		// Stream<T>: Mỗi phần từ là T: Integer, Double, Item, String, Tuple
		// Stream<Integer>: Sử dụng các hàm của KDL Stream, áp dụng chung cho kiểu T
		
		// Primitive Stream --> IntStream(từng phần tử là int), DoubleStream(từng phần tử là double), LongStream
		// IntStream: Sử dụng các hàm đặc thủ của primitive stream ví dụ IntStream hỗ trợ cho int
		//          : Lưu trữ tránh boxing tốn memory
		int[] oddDigits = Arrays.stream(digits) // IntStream
			.filter(nb -> nb % 2 != 0) // IntStream
			.distinct() // IntStream
			.toArray(); // int[]
		
		generate("2. Odd Digits", oddDigits);
		
		// distinct: những phần tử trùng nhau lấy 1 phần tử 1,2,2,3,3,4 --> 1,2,3,4
		// unique: chỉ lấy những phần tử xuất hiện 1 lần 1,2,2,3,3,4 --> 1,4
		
		var letters = List.of("a", "b", "b", "b", "c", "c", "d", "d", "d", "e");
		
		// .collect(Collectors.groupingBy(letter -> letter)) -->  Map<String, List<String>>
		// a -> {a}
		// b -> {b,b,b}
		// c -> {c,c}
		// d -> {d,d,d}
		// e -> {e}
		
		// .collect(Collectors.groupingBy(letter -> letter, Collectors.))
		// a -> 1
		// b -> 3
		// c -> 2
		// d -> 3
		// e -> 1
		
		var letterCounters = letters.stream()
				.collect(Collectors.groupingBy(letter -> letter, Collectors.counting())); // Map<String, Long>
		generate("3. Letter Groups", letterCounters.entrySet());
		
		var uniqueElements = letterCounters.entrySet()
				.stream()
				.filter(e -> e.getValue() == 3)
				.map(e -> e.getKey())
				.collect(Collectors.joining(", "));
		System.out.println("4. Unique elements --> " + uniqueElements);
		
		System.out.println("\n============ distinct by key/property ============\n");

		// Liệt kê danh sách các Apple (k được trùng origin/color)
		var menu = DataModel.mockApples();
		
		// Cách 1: Dùng set để distinct danh sách theo thuộc tính
		//         nếu có n phần tử trùng nhau -> luôn chọn phần tử đầu tiên
		var nonOverlapOrigin = new HashSet<String>();
		
		var applesDisOrigin = menu.stream()
				.filter(a -> nonOverlapOrigin.add(a.getOrigin()))
				.toList();
		generate("5. Apples non duplicate origin", applesDisOrigin);
		
		// Cách 2: Dùng map để distinct, chọn đc phần tử đầu/cuối khi thuộc tính trùng nhau
		var applesDisColor = menu.stream()
				.collect(Collectors.toMap(Apple::getColor, Function.identity(), (a1, a2) -> a1))
				.values();
		// a -> a = Function.identity()
		generate("6. Apples non duplicate color", applesDisColor);
	}
}
