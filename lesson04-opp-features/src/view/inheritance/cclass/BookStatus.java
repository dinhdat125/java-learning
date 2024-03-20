package view.inheritance.cclass;

public enum BookStatus {
	// để truy cập các biến (đối tượng) trong enum -> BookStatus.NEW , BookStatus.OLD
	//												-> BookStatus[] statuses = BookStatus.value();
	
	//mặc định -> name, ordinal(thứ tự trong enum: 0, 1, ..)
	
	// NEW -> BookStatus NEW = new BookStatus();
	// OLD -> BookStatus OLD = new BookStatus();
	
	NEW,
	OLD;
	
	private String value;
	
	
}
