package homework;

import java.util.Arrays;
import java.util.Random;

public class Matrix {

	private int row;
	private int column;
	private int[][] value;
	
	public Matrix() {
		// TODO Auto-generated constructor stub
	}
	
	public Matrix(int row, int column, int[][] value) {
		super();
		this.row = row;
		this.column = column;
		this.value = value;
	}

	public Matrix(int row, int column) {
		Random rd = new Random();
		this.row = row;
		this.column = column;
		this.value = new int[row][column];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				this.value[i][j] = rd.nextInt(1,100);
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int[][] getValue() {
		return value;
	}

	public void setValue(int[][] value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Matrix [row=" + row + ", column=" + column + ", value=" + Arrays.toString(value) + "]";
	}
	
//	public void show() {
//		for (int i = 0; i < this.row; i++) {
//			for (int j = 0; j < this.column; j++)
//				System.out.print(this.value[i][j] + "\t");
//			System.out.println("");
//		}	
//	}
	
}
