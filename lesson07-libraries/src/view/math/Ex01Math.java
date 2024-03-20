package view.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static utils.NumberUtils.*;

public class Ex01Math {

	public static void main(String[] args) {
		// phân trang: paging - pagination
		// click vào menu -> mặt hàng -> item -> 20item
		
		// tổng số item -> TotalItems = 20
		// cấu hình số mặt hàng trên 1 trang -> ItemPerPage = 4
		
		// số page -> 20/4 -> TotalPages = 5
		// 			  22/4 -> 			   5.5 -> roundup = 6 pages
		
		int totalItems = 23;
		int itemsPerPage = 4;
		
		int totalPages = (int)Math.ceil((float)totalItems/itemsPerPage);
		System.out.println("totalPages -> " + totalPages);	//6
		
		float test = 1.234f;
		System.out.println("Bigdecimal test1 -> " + BigDecimal.valueOf(test));
		System.out.println("Bigdecimal test2 -> " + new BigDecimal(test));
		System.out.println("Bigdecimal test3 -> " + new BigDecimal(String.valueOf(test)));
		
		float val = 10f/3;	//3.3333333 -> mặc định phần thập phân 7 chữ số 
		float fv = 17f/7;	//2.4285715 -> 		"
		
		System.out.println("val -> " + val);
		System.out.println("fv -> " + fv);
		
		// -> sử dụng BigDecimal
		
		// Dùng hàm này khi muốn chia lấy kq nhiều số thập phân có thể, k qt chính xác bao nhiêu chữ số
		// MathContext.DECIMAL32 -> 7 digits, 64 -> 16 digits, 128 -> 34 digits
		BigDecimal bdValue1 = bd(17).divide(bd(7), MathContext.DECIMAL64);
		System.out.println("bdValue -> " + bdValue1);
		BigDecimal bdValue2 = bd(17).divide(bd(7), MathContext.DECIMAL128);
		System.out.println("bdValue -> " + bdValue2);
		
		// Dùng hàm này khi muốn lấy chính xác bao nhiêu chữ số và chế độ làm tròn (HALF_UP, UP, DOWN)
		BigDecimal bdValue3 = bd(17).divide(bd(7), 10, RoundingMode.HALF_UP);
		System.out.println("bdValue -> " + bdValue3);
		
		// Số -> Làm tròn -> Kết quả vẫn là số -> dùng số để tính toán -> BigDecimal, Math
		
		// Số -> Định dạng -> Trả về String hiển thị ra console với những format khác nhau 
		// -> NumberFormat, DecimalFormat

	}
	
}
