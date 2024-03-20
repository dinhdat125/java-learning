package view;

import java.util.Arrays;

import common.SortType;

public class Ex04Sort {

	public static void main(String[] args) {
		String[] sequences = {"-2", "-6", "10", null, "4", "41", "8", 
				null, "Special", "a", "c", "b", "xx"};
		
		sort(sequences, SortType.ASC);
		System.out.println("Tăng dần: " + Arrays.toString(sequences));
		
		sort(sequences, SortType.DESC);
		System.out.println("Giảm dần: " + Arrays.toString(sequences));
	}
	
	private static void sort(String[] elements, SortType sortType) {
		Arrays.sort(elements, (s1, s2) -> {
			if (s1 == null)
				return 1;
			if (s2 == null)
				return -1;
			if (s1.equals("Special"))
				return -1;
			if (s2.equals("Special"))
				return 1;
			try {
				Integer i1 = Integer.parseInt(s1);
				Integer i2 = Integer.parseInt(s2);
				return i1.compareTo(i2);
			} catch (NumberFormatException e) {
				return s1.compareTo(s2);
			}
		});
		if (sortType == SortType.DESC)
			reverse(elements);
	}
	
	private static void reverse(String[] elements) {
		for (int i = 0; i < elements.length / 2; i++) {
			swap(elements, i, elements.length - i - 1);
		}
	}
	
	private static void swap(String[] elements, int a, int b) {
		String temp = elements[a];
		elements[a] = elements[b];
		elements[b] = temp;
	}
}
