package view.math;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Ex02Format {

	public static void main(String[] args) {
		//singleton pattern: là pattern cho viện khởi tạo đối tượng
		//class áp dụng singleton, chỉ cho phép tạo ra duy nhất 1 đt cho class đó
		
		double value = 748324832423132.466d;
		System.out.println("value -> " + value);

		System.out.println("default -> " + Locale.getDefault());
		//NumberFormat: sử dụng format có sẵn trong class -> k thể biến đổi
		//NumberFormat nf = NumberFormat.getInstance();	//singleton pattern
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")); //format ra tiền tệ
		String fmtValue = nf.format(value);
		System.out.println("fmtValue -> " + fmtValue);
		
		// Decimal Format -> format với định dạng, pattern truyền vào
		value = 756.441;
		DecimalFormat df = new DecimalFormat("#,###.##");
		String dffmValue = df.format(value);
		System.out.println("dffmValue -> " + dffmValue);
		
		// --> Công thức, tính toán, làm tròn -> dùng BigDecimal -> setScale(scale, roundingMode)
	}
}
