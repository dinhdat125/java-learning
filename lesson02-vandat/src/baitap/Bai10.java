package baitap;

import java.util.Arrays;
import java.util.Random;

public class Bai10 {
	public static void main(String[] args) {
		Random rd = new Random();
		
		int[] numbers = new int[5];
		numbers[0] = rd.nextInt(20,31);		//random được phần tử đầu tiền trong mảng
		
		for (int i = 1; i < numbers.length; i++) {
			do {
				numbers[i] = rd.nextInt(20,31);		//random được phần tử thứ i trong mảng
				int count = 0;
				for (int j = 0; j < i; j++) {
					if (numbers[i] == numbers[j]) {		//kiểm tra phần tử thứ i có bằng giá trị với
						count ++;						//các phần tử đã có trong mảng hay k
						break;
					}
				}
				if ( count > 0 ) continue;				//nếu có thì tiếp tục thực hiện lại vòng do while
				else break;								//nếu k thì thoát vòng do while
			} while (true);
		}
		
		System.out.println(Arrays.toString(numbers));
		
	}
}
