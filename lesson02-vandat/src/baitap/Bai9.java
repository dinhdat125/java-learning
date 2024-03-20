package baitap;

public class Bai9 {
	public static void main(String[] args) {
		
		int number = 1;		//tạo số nguyên cần kiểm tra số có phải là số nguyên tố hay k
		int count = 0;		//biến đếm số nguyên tố thứ bao nhiêu
		while (count != 200) {		//dừng lại khi đếm được đến số nguyên tố thứ 200
			number++;
			if (isPrime(number)) count++;
		}
		System.out.println("Số nguyên tố thứ 200 là : " + number);
		
	}
	
	//hàm kiểm tra có phải số nguyên tố hay k
	private static boolean isPrime(int number) {
		if (number <= 1) return false;
		for (int i = 2; i <= number/2; i++)
			if (number % i == 0) return false;
		return true;
	}
}
