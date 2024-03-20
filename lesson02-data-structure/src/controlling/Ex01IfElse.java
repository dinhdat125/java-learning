package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Ex01IfElse {
	public static void main(String[] args) {
		//random 1 số nguyên từ 5 đến 20
		Random rd = new Random();
		int number = rd.nextInt(5,20);
		
		//kiểm tra số nguyên đó có phải là số chẵn k
		if (number % 2 == 0) {
			System.out.println("Random number is even number -> " + number);
		}
		
		//kiểm tra tính hợp lệ độ dài mật khẩu nhập vào
		String password = "dgrnngwrd";
		if (password.length() >= 8) {
			System.out.println("Mật khẩu hợp lệ");
		} else {
			System.out.println("Mật khẩu không hợp lệ");
		}
		
		//nhập vào điểm trung bình của sv [0,10]
		//[0,5) yếu ; [5,6.5) tb ; [6.5,8) khá ; [8,10] giỏi
		
		float avgPoint = rd.nextFloat(10.1f);
		if (avgPoint > 10) {
			avgPoint = 10;
		}
		// avgPoint = avgPoint > 10 ? 10 : avgPoint;
		
		System.out.println("Điểm : " + BigDecimal.valueOf(avgPoint).setScale(1, RoundingMode.HALF_UP));
		if (avgPoint < 5) {
			System.out.println("Yếu");
		} else if (avgPoint < 6.5) {
			System.out.println("Trung bình");
		} else if (avgPoint < 8) {
			System.out.println("Khá");
		} else {
			System.out.println("Giỏi");
		}
		
		//toán tử 3 ngôi -> (exp1) ? stm2 : stm3
		//nếu exp1 true -> thực hiện stm2, f -> thực hiện stm3
		
		//tìm max của 2 số a , b -> int max = (a > b) ? a : b;
		
		
	}
}
