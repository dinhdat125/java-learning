package view.inheritance.cclass;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BookApp {
	public static void main(String[] args) {
		/*
		 Cho app quản lý thông tin sách trong cửa hàng
		 thông tin sách:
		 + sách tham khảo: mã sách, tên sách, nhà xuất bản, thuế %
		 + sách giáo khoa: mã sách, tên sách, nhà xuất bản, trạng thái, giảm giá %
		 
		 *trạng thái:
		 	KDL -> enum( enumration )
		 		-> khi muốn lưu trữ tập hợp các giá trị hằng số, bất biến (immutable)
		 		-> KDL đối tượng
		 			lưu trữ tập các đối tượng là immutable bên trong nó
		 		-> default empty constructor -> private ( not fix to public,... )
		 
		 tạo ds n cuốn sách
		 -> thực hiện việc mua k/n cuốn sách và tính tổng tiền phải trả
		 */
		Book[] books = mockBooks();
		
		Book[] salesBook = {books[0], books[1], books[3], books[5], books[7]};
		
		BigDecimal totalOfMoney = BigDecimal.ZERO;
		for (Book book: salesBook) {
			// book != null && book.getClass() == TextBook.class
			// -> book instanceof TextBook
			
			BigDecimal salesPrice = book.getSalesPrice();
			
			if (book instanceof TextBook) {
				TextBook tb = (TextBook)book;
				salesPrice = salesPrice.multiply(bd(1).subtract(bd(tb.getDiscount()).divide(bd(100))));
			} else if (book instanceof ReferenceBook) {
				ReferenceBook ref = (ReferenceBook)book;
				salesPrice = salesPrice.multiply(bd(1).add(ref.getTax().divide(bd(100))));
			}
			
			System.out.println("book " + book.getId() + " has price -> " + salesPrice);
			totalOfMoney = totalOfMoney.add(salesPrice).setScale(2, RoundingMode.HALF_UP);
		}
		
		System.out.println("Tổng tiền phải trả -> " + totalOfMoney);
	}
	
	private static Book[] mockBooks() {
		return new Book[] {
				new TextBook("SGK-211", "Toán 7", "Việt Nam", bd(20), BookStatus.NEW, 2),
				new TextBook("SGK-541", "Hóa 8", "Nhi Đồng", bd(20), BookStatus.NEW, 5),
				new TextBook("SGK-236", "Lý 6", "Việt Nam", bd(30), BookStatus.OLD, 3),
				new TextBook("SGK-569", "Anh 7", "Nhi Đồng", bd(30), BookStatus.OLD, 2),
				new TextBook("SGK-771", "Văn 9", "Việt Nam", bd(20), BookStatus.NEW, 5),
				new ReferenceBook("STK-059", "Sử 6", "Nhi Đồng", bd(20), BigDecimal.valueOf(2)),
				new ReferenceBook("STK-469", "Địa 6", "Việt Nam", bd(20), bd(2)),
				new ReferenceBook("STK-188", "Sinh 6", "Nhi Đồng", bd(30), bd(2)),
				new ReferenceBook("STK-369", "Văn 6", "Nhi Đồng", bd(20), bd(4)),
		};
	}
	
	private static BigDecimal bd(double value) {
		return BigDecimal.valueOf(value);
	}
}
