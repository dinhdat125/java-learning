package view.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02AList_SingleType {

	public static void main(String[] args) {
		// List<String> sequences = new ArrayList<>(); JDK 1.7
		
		var sequences = new ArrayList<String>();	// JDK 10
		
		/*
		 Khi nào mình sẽ khởi tạo ArrayList với tham số capacity truyền vào
		--> Khi biết trước được số lượng phần tử tối đa sẽ lưu trữ trong ArrayList
		--> TH1: tối da < 10: tạo 1 mảng ít phần tử hơn mặc định đỡ tốn memory
			List<String> sequences = new ArrayList<>(5);
		--> TH2: tối đa > 10: tạo 1 mảng duy nhất, hạn chế phải grow copy tạo mảng nhiều lần
			List<String> sequences = new ArrayList<>(100);
		 */
		
		sequences.add("word");
		sequences.add("000");
		sequences.add("text");
		sequences.add("excel");
		sequences.addAll(List.of("a", "c"));
		
		sequences.set(2, "gg");
		sequences.remove(1);
		
		System.out.println("1. Sequences size: " + sequences.size());
		printf("2. Sequences", sequences, " ");
	}
	
	private static void printf(String prefix, List<String> sequences, String delimiter) {
		System.out.print(prefix + " -> ");
		for (String sequence:sequences)
			System.out.print(sequence + delimiter);
	}
}
