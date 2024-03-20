package video_array;

import java.util.Arrays;

public class Ex03FilterString {
	public static void main(String[] args) {
		String[] students = {"Kaka", "Peter", "Valarane", "Patrick"};
		
		System.out.println(Arrays.toString(getStudents(students)));
	}
	
	private static String[] getStudents(String[] elements) {
		String[] result = new String[elements.length];
		int count = 0;
		for(String element: elements) {
			if(element.startsWith("P")) {
				result[count] = element;
				count++;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
		//hàm copy từ phần tử tứ 0 đến phần tử count-1 từ mảng result
	}
}
