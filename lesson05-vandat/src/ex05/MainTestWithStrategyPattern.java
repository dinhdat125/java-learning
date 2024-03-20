package ex05;

public class MainTestWithStrategyPattern {

	public static void main(String[] args) {
		Book[] books = input();
		
		System.out.println("Sách thuộc nhà xuất bản Kim Đồng:");
		findBooks(books, book -> book.getPublishingCompany() == "Nhi Đồng");
		
		System.out.println("Sách có đơn giá nhỏ hơn 50:");
		findBooks(books, book -> book.getPrice() < 50000);
		
		System.out.println("Sách có đơn giá từ 100 đến 200:");
		findBooks(books, book -> (book.getPrice() < 200000 && book.getPrice() > 100000));
		
	}
	
	private static void findBooks(Book[] books, Strategy strategy) {
		for (Book book:books) {
			if (strategy.process(book)) {
				System.out.println(book.getId());
			}
		}
	}
	
	private static Book[] input() {
		TextBook tx1 = new TextBook("SGK-345", 64000l, "Nhi Đồng", BookStatus.NEW);
		TextBook tx2 = new TextBook("SGK-945", 44000l, "Kim Đồng", BookStatus.NEW);
		TextBook tx3 = new TextBook("SGK-396", 38000l, "Nhi Đồng", BookStatus.OLD);
		ReferenceBook rf1 = new ReferenceBook("STK-887", 36000l, "Giáo Dục", 0.03f);
		ReferenceBook rf2 = new ReferenceBook("STK-547", 116000l, "Nhi Đồng", 0.04f);
		
		Book[] books = {tx1, tx2, tx3, rf1, rf2};
		
		return books;
	}
}
