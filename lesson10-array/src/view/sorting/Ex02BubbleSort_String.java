package view.sorting;

import static utils.ArrayUtils.*;

import functional.Compare_String;

public class Ex02BubbleSort_String {

	/*
	 Sorting with [non]-null values
	 + null first/last
	 	. first -> null < non-null
	 	. last -> null > non-null
	 + ascending/descending (non-null)
	 */
	
	public static void main(String[] args) {
		String[] elements = {"a1", "lzt3", null, "12", "k7", "c13", "b22", "4", null, "h5"};
		generate("1. Elements", elements);
		
//		sortAsc(elements);
//		generate("2. Elements(sort ascending)", elements);
		
		sort(elements, (s1, s2) -> {
			// process null elements (e.g null first)
			if (s1 == null)
				return 0;
			if (s2 == null)
				return 1;
			// process non-null elements
			return s1.compareTo(s2);
		});
		generate("2. Elements(sort ascending - first null)", elements);
		
		sort(elements, (s1, s2) -> {
			// process null elements (e.g null last)
			if (s2 == null)
				return 0;
			if (s1 == null)
				return 1;
			// process non-null elements
			return s1.compareTo(s2);
		});
		generate("2. Elements(sort ascending - last null)", elements);
		
		sort(elements, (s1, s2) -> {
			// process null elements (e.g null first)
			if (s1 == null)
				return 0;
			if (s2 == null)
				return 1;
			// process non-null elements
			return s2.compareTo(s1);
		});
		generate("3. Elements(sort descending - first null)", elements);
		
		sort(elements, (s1, s2) -> {
			// process null elements (e.g null last)
			if (s2 == null)
				return 0;
			if (s1 == null)
				return 1;
			// process non-null elements
			return s2.compareTo(s1);
		});
		generate("3. Elements(sort descending - last null)", elements);
	}
	
	private static void sort(String[] elements, Compare_String compareString) {
		for (int i = 0; i < elements.length; i++)
			for (int j = 0; j < elements.length - i - 1; j++)
				if (compareString.compare(elements[j], elements[j+1]) > 0)
					swap(elements, j, j+1);
	}
		
//	private static void sortAsc(String[] elements) {
//		for (int i = 0; i < elements.length; i++)
//			for (int j = 0; j < elements.length - i - 1; j++)
//				if (elements[j].compareTo(elements[j+1]) > 0)
//					swap(elements, j, j+1);
//	}
	
}
