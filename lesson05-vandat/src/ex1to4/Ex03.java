package ex1to4;

public class Ex03 {

	public static void main(String[] args) {
		String string = "12abu02muzk586cyx";	//Uyk892nn1234uxo2
		System.out.println(string + " -> " + getMaxValidNumber(string));
	}
	
	private static int getMaxValidNumber(String s) {
		String[] replaces = s.split("[^\\d]+");		//lọc các kí tự là số lưu vào mảng
		
		int max = 0;
		for (String replace : replaces)
			max = Integer.parseInt(replace) > max ? Integer.parseInt(replace) : max;
		return max;
	}
}
