package ex02;


public class Main02 {

	public static void main(String[] args) {
		int[] arr = new int[] {12, 21, 25, 19, 32, 35, 49, 10, 33, 14, 18};
		int n = arr.length;

		System.out.print("Input:\t");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");

		int countFirst = 0;
		int countLast = 0;
		for (int i = 0; i < n - countLast; i++) {
			// cách 1: đúng đk thì tịnh tiến giá trị
			if (arr[i] % 7 == 0 && arr[i] % 5 != 0) {
				int temp = arr[i];
				for (int j = i; j > countFirst; j--)
					arr[j] = arr[j-1];
				// cách 2: đúng đk thì hoán đổi 2 giá trị cho nhau
				// arr[i] = arr[countFirst];
				arr[countFirst] = temp;
				countFirst++;
			}
			if (arr[i] % 5 == 0 && arr[i] % 7 != 0) {
				int temp = arr[i];
				for (int j  = i; j < n - 1 - countLast; j++)
					arr[j] = arr[j+1];
				// arr[i] = arr[n - 1 - countLast];
				arr[n - 1 - countLast] = temp;
				countLast++;
				i--;
			}
			
		}
		
		System.out.print("Ouput:\t");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		
	}
}
