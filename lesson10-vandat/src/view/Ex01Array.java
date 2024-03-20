package view;

import java.util.Arrays;

public class Ex01Array {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,5,3,1};
		System.out.println(Arrays.toString(numbers) + "\n");
		
		removeDuplicateElements(numbers);
		compare(numbers);
		find3rdLargestNumber(numbers);
	}
	
	private static void removeDuplicateElements(int[] numbers) {
		int[] elements = new int[numbers.length];
		copy(numbers, elements);
		Arrays.sort(elements);
		
		int[] result = new int[elements.length];
		int lenght = 0;		// lenght of result[]
		for (int i = 0; i < elements.length; i++) {
			int count = 1;
			while (i < elements.length - 1 && elements[i] == elements[i+1]) {
				i++;
				count++;
			}
			if (count == 1) {
				result[lenght++] = elements[i];
			}
		}
		result = Arrays.copyOfRange(result, 0, lenght);
		System.out.println("Mảng sau khi loại bỏ phần tử trùng nhau: " + Arrays.toString(result) + "\n");
	}
	
	private static void compare(int[] numbers) {
		/*
		 n = 6
		 0 1 2 3 4 5    center = 3
		 0			-> 2 (< 3)	half = 3
		 5 (< 6)	-> 3
		 
		 n = 5
		 0 1 2 3 4		center = 2.5, half = 3
		 0			-> 2 (< 2.5)	half = 3
		 4 (< 5)	-> 2
		 */
		int[] elements = new int[numbers.length];
		copy(numbers, elements);
		Double averageFirstHalf = 0.0;
		Double averageLastHalf = 0.0;
		double center = elements.length / 2.0;
		int half = 0;
		
		for (int i = 0; i < center; i++) {
			averageFirstHalf += elements[i];
			half++;
		}
		center = (int)center;
		averageFirstHalf /= half;
		
		for (int i = elements.length - 1; i >= center; i--) {
			averageLastHalf += elements[i];
		}
		averageLastHalf /= half;
		
		System.out.println("Giá trị trung bình nửa phần tử đầu tiên trong mảng là " + averageFirstHalf);
		System.out.println("Giá trị trung bình nửa phần tử cuối cùng trong mảng là " + averageLastHalf);
		switch (averageFirstHalf.compareTo(averageLastHalf)) {
		case 1:
			System.out.println("=> Nửa đầu lớn hơn\n");
			break;
		case -1:
			System.out.println("=> Nửa cuối lớn hơn\n");
			break;
		default:
			System.out.println("=> Hai nửa bằng nhau\n");
		}
	}
	
	private static void find3rdLargestNumber(int[] numbers) {
		if (numbers.length < 3) {
			System.out.println("Không tồn tại số lớn thứ 3 trong mảng !");
			return;
		}
		
		int[] elements = new int[numbers.length];
		copy(numbers, elements);
		Arrays.sort(elements);
		
		int count = 1;
		for (int i = elements.length - 1; i > 0; i--) {
			if (elements[i] != elements[i-1]) {
				count++;
			}
			if (i == 1 && count < 3) {
				System.out.println("Không tồn tại số lớn thứ 3 trong mảng !!");
				return;
			}
			if (count == 3) {
				System.out.println("Số lớn thứ 3 trong mảng -> " + elements[i-1]);
				return;
			}
		}
	}
	
	private static void copy(int[] origin, int[] target) {
		for (int i = 0; i < origin.length; i++) {
			target[i] = origin[i];
		}
	}
}
