package view;

import java.util.Arrays;

public class Ex02Matrix {

	public static void main(String[] args) {
		int[][] matrix = input();
		System.out.println("INPUT");
		output(matrix);
		
		matrixConversionAdvanced(matrix);
		System.out.println("OUTPUT");
		output(matrix);
	}
	
	/*
	private static void matrixConversion(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int check = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					writeZero(matrix, i, j);
					check = 1;
					break;
				}
			}
			if (check == 1)
				break;
		}
	}
	*/
	
	private static void matrixConversionAdvanced(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		// mảng 2 chiều chứa vị trí phần tử có giá trị 0 trong matrix
		int[][] zeroLocation = new int[row * col][2];
		
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					zeroLocation[count][0] = i;
					zeroLocation[count++][1] = j;
				}
			}
		}
		zeroLocation = Arrays.copyOfRange(zeroLocation, 0, count);
		
		for (int i = 0; i < zeroLocation.length; i++) {
			writeZero(matrix, zeroLocation[i][0], zeroLocation[i][1]);
		}
	}
	
	private static void writeZero(int[][] matrix, int row, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}
	
	private static void output(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++)
				System.out.print(matrix[row][col] + " ");
			System.out.println();
		}
	}
	
	private static int[][] input(){
		return new int[][] {
			{1, 2, 3, 4},
			{5, 0, 8, 7},
			{1, 9, 0, 9},
			{2, 0, 6, 5},
			{1, 2, 4, 5}
		};
	}
}
