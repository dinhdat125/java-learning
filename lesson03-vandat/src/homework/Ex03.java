package homework;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập số hàng của ma trận -> ");
		int row = ip.nextInt();
		System.out.print("Nhập số cột của ma trận -> ");
		int column = ip.nextInt();
		
		Matrix matrix = new Matrix(row, column);
		
		MatrixUtils.show(matrix);
		
		MatrixUtils.horseSaddle(matrix);
	}
}
