package view.sorting.available.method;

import java.util.Arrays;

import common.SortType;

import static utils.ArrayUtils.*;

public class Ex01QuickSort_Int {

	public static void main(String[] args) {
		// list, set, map -> sort
		
		// array -> sort
		int[] elements = {1,3,5,2,4};
		
		// no support for descending with primitive type
		Arrays.sort(elements);
		generate("1. Sort items(default asc)", elements);
		
		sort(elements, SortType.DESC);
		generate("1. Sort items(desc)", elements);
	}
}
