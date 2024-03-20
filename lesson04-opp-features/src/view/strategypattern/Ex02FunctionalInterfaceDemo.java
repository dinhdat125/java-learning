package view.strategypattern;

public class Ex02FunctionalInterfaceDemo {

	public static void main(String[] args) {
		
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		
		//đếm số lượng phần tử chẵn
		System.out.println("Số phần tử chẵn -> " + countAmountOfMultipleOf2Numbers(numbers));
		
		//strategy pattern
		//đếm số lượng phần tử lẻ
		System.out.println("Số phần tử lẻ -> " + countIf(numbers, number -> number % 2 != 0));
		
		//đếm số lượng phần tử chia hết cho 3
		System.out.println("Số phần tử chia hết cho 3 -> " + countIf(numbers, number -> number % 3 == 0));
		
		//đếm số lượng phần tử chia hết cho 5
		System.out.println("Số phần tử chia hết cho 5 -> " + countIf(numbers, number -> number % 5 == 0));
		
		//đếm số lượng phần tử là số nguyên tố
		System.out.println("Số phần tử là số nguyên tố -> " + countIf(numbers, number -> isPrime(number)));
	}
	
	// viết 1 hàm truyền vào strategy
	// strategy là 1 hàm biết đc số lượng tham số và KDL trả về, chưa biết phần
	// khi nào ai gọi hàm này thì truyền nội dung strategy vào
	private static int countIf(int[] numbers, IntTest intTest) {
		int count = 0;
		for (int number:numbers)
			if (intTest.test(number))
				count++;
		return count;
	}
	
	private static int countAmountOfMultipleOf2Numbers(int[] numbers) {
		int count = 0;
		for (int number:numbers)
			if (number % 2 == 0)
				count++;
		return count;
	}
	
	private static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++)
			if ( number % i == 0)
				return false;
		return true;
	}
}
