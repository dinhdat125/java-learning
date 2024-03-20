package ex03;

import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap n = ");
		int n = ip.nextInt();
		long[][] arr = new long[n+1][n+2];
		
		arr[0][0] = 1;
		arr[0][1] = 1;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				arr[i][0] = 1;
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
			arr[i][i+1]= 1;
		}
		
		System.out.println("Tam giác Pascal");
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= i+1; j++){
				System.out.print(arr[i][j] +"\t");
			}
			System.out.println("");
		}
		ip.close();
	}
}
