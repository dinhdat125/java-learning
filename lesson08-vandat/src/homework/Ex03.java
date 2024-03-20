package homework;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Ex03 {

	public static void main(String[] args) {
		String s1 = "Em có yêu anh không .Để anh biết còn chờ";
		String s2 = "Em xin lỗi em đã có thái độ không đúng với anh";
		
		System.out.println("Chuỗi gốc: " + s1 + "\nBỏ dấu --> " + removeAccent(s1));
		System.out.println("Chuỗi gốc: " + s2 + "\nBỏ dấu --> " + removeAccent(s2));
	}
	
	private static String removeAccent(String s) { 
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		temp = pattern.matcher(temp).replaceAll(""); 
    
		return temp.replaceAll("đ", "d").replaceAll("Đ", "D");
	}
}
