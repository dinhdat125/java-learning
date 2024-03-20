package view.sorting;

import static utils.ArrayUtils.*;

import functional.Compare_Int2;

public class Ex01BubbleSort_Int2 {

	// cách java hỗ trợ sorting
	// int compare(E e1, E e2)
	
	public static void main(String[] args) {
		int[] elements = {1,3,5,2,4};
		generate("1. Elements", elements);
		
		sortAsc(elements);
		generate("2. Elements(sort ascending)", elements);
		sortDesc(elements);
		generate("2. Elements(sort descending)", elements);
		
		sort(elements, (a, b) -> a - b);
		generate("2. Elements(sort ascending)", elements);
		sort(elements, (a, b) -> b - a);
		generate("2. Elements(sort descending)", elements);
	}
	
	private static void sort(int[] elements, Compare_Int2 compareInt2) {
		for (int i = 0; i < elements.length; i++)
			for (int j = 0; j < elements.length - i - 1; j++)
				// nếu compare() trả về số dương -> hoán vị
				if (compareInt2.compare(elements[j], elements[j+1]) > 0)
					swap(elements, j, j+1);
	}
	
	private static void sortAsc(int[] elements) {
		for (int i = 0; i < elements.length; i++)
			for (int j = 0; j < elements.length - i - 1; j++)
				if (elements[j] - elements[j+1] > 0)
					swap(elements, j, j+1);
	}
	
	private static void sortDesc(int[] elements) {
		for (int i = 0; i < elements.length; i++)
			for (int j = 0; j < elements.length - i - 1; j++)
				if (elements[j] - elements[j+1] < 0)
					swap(elements, j, j+1);
	}
}
