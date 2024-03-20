package view.stream;

import static utils.StreamUtils.generate;

import java.util.List;

import bean.Pair;

public class Ex03IntermediateTerminalOperations {
	
	public static void main(String[] args) {
		var sequences = List.of("aa", "b", "1", "cbna", "dc", "2", "ft", "g");
		
		var pairs = sequences.stream() // Stream<String>
			.filter(seq -> {
				System.out.println("test filter --> " + seq);
				return seq.matches("[a-z]+");
				}) // Stream<String>
			.map(seq -> new Pair<>(seq, seq.length())) // Stream<Pair>
			.limit(4) // Stream<Pair>
			.toList(); // List<Pair<>>
			
		generate("1. Pairs", pairs);
	}
	
}
