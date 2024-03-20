package video_array;

public class Ex01ArrayOperation {
	public static void main(String[] args) {
		
		//number là kiểu mảng int
		int[] numbers = new int[6];
		//index: 0 1 2 3 4 5
		//value: 0 0 0 0 0 0
		numbers[2] = 2;
		
		//forindex
		for(int i = 0; i < numbers.length; i++)
			System.out.println("Value at index " + i + ": " + numbers[i]);
		
		//foreach
		for(int number : numbers)
			System.out.println("Number: " + number);
		
		String[] sequences = {"hello", "hi", "welcome"};
		System.out.println("lenght: " + sequences.length);
		for(String sequence: sequences)
			System.out.println(sequence);
	}
}
