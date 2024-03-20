package view.stream;

import java.util.List;
import java.util.Optional;

public class Ex07Optional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(4, 2, 9, 3, 14, 1);
		
		Optional<Integer> optMaxOdd = findMaxOddNumber(numbers);
		if (optMaxOdd.isPresent())
			System.out.println("Max odd number: " + optMaxOdd.get());
		else
			System.out.println("List has no odd number");
		// or
		System.out.println("=======================");
		optMaxOdd.ifPresentOrElse(
				value -> System.out.println("Max odd number: " + value),
				() -> System.out.println("List has no odd number"));
	}
	
	private static Optional<Integer> findMaxOddNumber(List<Integer> numbers) {
		Integer max = null;
		for (Integer number: numbers) {
			if (number % 2 != 0 && max == null)
				max = number;
			else
				if (number % 2 != 0 && max < number)
					max = number;
		}
		return Optional.ofNullable(max);
	}
}
