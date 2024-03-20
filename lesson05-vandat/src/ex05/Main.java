package ex05;

public class Main {

	public static void main(String[] args) {
		TextBook tx1 = new TextBook("SGK-345", 64000l, "Nhi Đồng", BookStatus.NEW);
		TextBook tx2 = new TextBook("SGK-945", 44000l, "Kim Đồng", BookStatus.NEW);
		TextBook tx3 = new TextBook("SGK-396", 38000l, "Nhi Đồng", BookStatus.OLD);
		ReferenceBook rf1 = new ReferenceBook("STK-887", 36000l, "Giáo Dục", 0.03f);
		ReferenceBook rf2 = new ReferenceBook("STK-547", 116000l, "Nhi Đồng", 0.04f);
		
		Book[] books = {tx1, tx2, tx3, rf1, rf2};
		
		System.out.println("Sách thuộc nxb Kim Đồng");
		isBookOfKD(books);
		
		System.out.println("Sách có đơn giá nhỏ hơn 50.000đ");
		isBookBigger50(books);
		
		System.out.println("Sách có đơn giá từ 100.000 đến 200.000đ");
		isBook100to200(books);
		
		Book[] bookBuy = {tx2, rf1};
		System.out.println("Tiền mà khách hàng phải trả khi mua sách có mã "
				+ bookBuy[0].getId() + " và " + bookBuy[1].getId() + " là " + payment(bookBuy));
	}
	
	private static void isBookOfKD(Book[] books) {
		for (Book book:books) {
			if (book.getPublishingCompany() == "Nhi Đồng")
				System.out.println(book.getId());
		}
	}
	
	private static void isBookBigger50(Book[] books) {
		for (Book book:books) {
			if (book.getPrice() < 50000)
				System.out.println(book.getId());
		}
	}
	
	private static void isBook100to200(Book[] books) {
		for (Book book:books) {
			if (book.getPrice() < 200000 && book.getPrice() > 100000)
				System.out.println(book.getId());
		}
	}
	
	private static long payment(Book[] books) {
		long total = 0;
		for (Book book:books) {
			if (book instanceof TextBook) {
				if(((TextBook) book).getStatus() == BookStatus.OLD)
					total += book.getPrice()*0.7;
				else total += book.getPrice();
			}
			if (book instanceof ReferenceBook) {
				total += book.getPrice()*(1.0 + ((ReferenceBook) book).getTax());
			}
		}
		return total;
	}
}
