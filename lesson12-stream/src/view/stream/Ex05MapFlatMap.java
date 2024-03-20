package view.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static utils.StreamUtils.*;

public class Ex05MapFlatMap {
	
	public static void main(String[] args) {
		
		// using list of cards
		List<List<String>> players = List.of(
				List.of("2 chuồn", "3 bích", "5 cơ"), // player 1
				List.of("5 chuồn", "6 bích", "7 cơ"), // player 2
				List.of("7 chuồn", "10 bích", "K cơ"), // player 3
				List.of("8 chuồn", "J bích", "2 cơ") // player 4
		);
		
		// Stream<Collection<T>> --> flatMap(col -> col.stream()) --> Stream<T>
		
		// Collection col -> col.stream() = Collection::stream
		
		// List<List<String>> --> List<String> {"2 chuồn", .. , "7 cơ", "8 chuồn", "J bích", "2 cơ"}
		var cards = players.stream() // Stream<List<String>>
			// .flatMap(list -> list.stream()) // Stream<String>
			.flatMap(Collection::stream) // Stream<String>
			.filter(card -> card.startsWith("2")) // Stream<String>
			.collect(Collectors.toSet()); // Set<String>
		
		generate("1. Cards", cards);
		
		// using array
		int[][] matrix = {
				{1,2}, 
				{3,4,5}, 
				{6,7}
		};
		
		int[] elements = Arrays.stream(matrix) // Stream<int[]>
			.flatMapToInt(a1D -> Arrays.stream(a1D)) // IntStream
			.toArray(); // int[]
		
		generate("2. Matrix elements", elements);
	}
}
