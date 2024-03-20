package view.sorting.available.method;

import java.util.Arrays;
import java.util.function.Function;

import static utils.ArrayUtils.*;

import static java.util.Comparator.*;

public class Ex04QuickSort_String {

	public static void main(String[] args) {
		String[] sequences = {"A1", "Z7", "K8", "E5", "B3"};
		
		Arrays.sort(sequences);
		generate("1. Sort sequences asc", sequences);
		
		Arrays.sort(sequences, (s1, s2) -> s2.compareTo(s1));
		generate("2. Sort sequences desc", sequences);
		
		String[] sequencesWithNullValues = {"A1", null, "Z7", "K8", "E5" , null, "B3"};
		
		// Function<String, String> f = s -> s
		// Function<String, String> f = Function.identity()

		Arrays.sort(sequencesWithNullValues, 
				nullsLast(comparing(Function.identity(), reverseOrder()))
		);
		generate("3. Sort sequences desc, null last", sequencesWithNullValues);
	}
}
