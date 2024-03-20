package view;

import functional.Operator;
import static utils.ArrayUtils.*;

public class Ex04ArrayManipultions {

	public static void main(String[] args) {
		/*
		 Cho mảng n phần tử số nguyên dương [1, 20]
		 Yêu cầu:
		 	1. Tìm tổng các phần tử trong mảng
		 	2. Tìm hiệu các phần tử trong mảng
		 	3. Tìm số lớn nhất trong mảng
		 	4. Tìm số bé nhất trong mảng
		 	5. Tìm giá trị trung bình của các phần tử trong mảng
		 */
		
		int[] numbers = {5,2,8,18,4};
		
		generate("1. Tìm tổng các phần tử trong mảng", reduce(0, (a, b) -> a + b, numbers));
		generate("2. Tìm hiệu các phần tử trong mảng", reduce(0, (a, b) -> a - b, numbers));
		generate("3. Tìm số lớn nhất trong mảng", reduce(Integer.MIN_VALUE, (a, b) -> a < b ? b : a, numbers));
		generate("4. Tìm số nhỏ nhất trong mảng", reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a, numbers));
		
	}
	
	// (int...numbers) --> numbers: nhận vào 0 | 1 | n phần tử int hoặc mảng int[]
	// (int[] numbers) --> numbers: nhận vào mảng int[]
	private static int reduce(int initial, Operator operator, int...numbers) {
		int result = initial;
		for (int number: numbers)
			result = operator.operator(result, number);
		return result;
	}
}
