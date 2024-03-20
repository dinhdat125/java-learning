package view;

import java.util.Arrays;

public class Ex01ArrayDeclaration {

	public static void main(String[] args) {
		// khai báo mảng 1 chiều
		
		int[] digits = new int[3];
		// digits là KDL đối tượng, thuộc class là [I (digits.getClass())
		int[] numbers = {2,4,3};
		//int[] numbers = new int[]{2,4,3}; -> thừa new int[] -> chỉ dùng khi return trong method
		
		System.out.println("digits class -> " + digits.getClass());
		System.out.println("numbers class -> " + numbers.getClass());
		
		String[] words = {"hello", "welcome"};
		System.out.println("words class -> " + words.getClass());
		System.out.println("words class -> " + words.getClass().getSimpleName());
		
		modify(words);
		System.out.println("words -> " + Arrays.toString(words));
		
		// khai báo mảng 2 chiều(thường sử dụng), n chiều(hạn chế sd)
		
		// mảng 1 chiều: mỗi phần tử là 1 giá trị đơn(nguyên thủy, đối tượng)
		// mảng 2 chiều: mỗi phần tử là 1 mảng 1 chiều
		// vd: ma trận(rows, columns)
		int[][] empty = new int[3][4];
		int[][] matrix = {
				{1,2,3,4},
				{2,6,6,4},
				{4,7,7,8}
		};
		System.out.println("empty -> " + Arrays.toString(empty));
		System.out.println("matrix[1] -> " + Arrays.toString(matrix[1]));
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++)
				System.out.print(matrix[row][col] + " ");
			System.out.println();
		}
		
		// mảng 3 chiều: mỗi phần tử là 1 mảng 2 chiều
		int[][][] b = {
				{{1,2}, {3}},
				{{2,2}, {4}},
		};
		System.out.println("b[0] -> " + b[0][1][0]);
		
		// mảng n chiều: mỗi phần tử là 1 mảng n-1 chiều
		// chuyển sang dùng mảng đối tượng
		// Type[] types = {new Type(1,2,3), new Type(3,4,6)};
		// b[0][1][0] -> Type[0].getZ();
	}
	
	private static void modify(String[] elements) {
		elements[1] = null;
	}
}
