package view;

import java.util.Arrays;

import static utils.ArrayUtils.*;

public class Ex02ArrayCrud {

	public static void main(String[] args) {
		int[] numbers = {2,9,6,5,4};
		System.out.println("numbers -> " + Arrays.toString(numbers));
		
		// create -> add
		generate("numbers after added", add(numbers, 3, 7));
		
		// read -> numbers[i]
		
		// update -> numbers[i] = value
		
		// delete -> remove
		generate("numbers after removed", remove(numbers, 2));
	}
	
	private static int[] add(int[] origin, int posToBeAdded, int newValue) {
		if (posToBeAdded < 0 || posToBeAdded >= origin.length) {
			System.out.println("ERROR");
			return origin;
		}
		int[] result = new int[origin.length + 1];
		for (int i = 0; i < origin.length; i++) {
			result[i] = origin[i];
		}
		for (int i = result.length - 1; i > posToBeAdded; i--) {
			result[i] = result[i-1];
		}
		result[posToBeAdded] = newValue;
		return result;
	}
	
	private static int[] remove(int[] origin, int posToBeRemoved) {
		if (posToBeRemoved < 0 || posToBeRemoved >= origin.length) {
			System.out.println("ERROR");
			return origin;
		}
		int[] result = new int[origin.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = origin[i];
		}
		for (int i = posToBeRemoved; i < origin.length - 1; i++) {
			result[i] = result[i+1];
		}
		return Arrays.copyOfRange(result, 0, origin.length - 1);
	}
}
