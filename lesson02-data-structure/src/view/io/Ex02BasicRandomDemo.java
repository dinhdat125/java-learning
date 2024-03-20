package view.io;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Ex02BasicRandomDemo {
	public static void main(String[] args) {
		Random rd = new Random();
		
		//tạo 1 số nguyên ngẫu nhiên
		int rn1 = rd.nextInt(); // từ Integer Min -> Integer Max
		
		//tạo 1 số nguyên ngẫu nhiên từ [0, n) -> inclusive 0, exclusive n
		int rn2 = rd.nextInt(20);
		
		//tạo 1 số nguyên ngẫu nhiên từ (a, b) 
		int rn3 = rd.nextInt(2, 10); // = int rn3 = 2 + rd.nextInt(8);
		
		System.out.println("" + rn1);
		System.out.println("" + rn2);
		System.out.println("" + rn3);
		
		//tạo 1 số thực ngẫu nhiên trong phạm vi float
		float rf1 = rd.nextFloat();
		
		//tạo 1 số thực ngẫu nhiên từ [0.0,n)
		float rf2 = rd.nextFloat(12.0f);
		
		float rf3 = rd.nextFloat(2.2f, 56.0f);
		
		//round up -> Math.cell
		//round down -> Math.floor
		///commercial round -> Math.round
		
		//float rf3Rounded = Math.round(rf3 * 100f)/100f;

		System.out.println("" + rf1);
		System.out.println("" + rf2);
		System.out.println("" + rf3);

		//DecimalFormat -> format to String for Presentation
		//Bigdecimal -> store big float number, 
		
		
		//chuyển đổi float/double sang Bigdecimal
		//design patterm -> bullder patterm
		BigDecimal bdf3 = BigDecimal.valueOf(rf3).setScale(4, RoundingMode.HALF_UP);
		//					ép kiểu					làm tròn
		
		System.out.println("" + bdf3);
	}
}
