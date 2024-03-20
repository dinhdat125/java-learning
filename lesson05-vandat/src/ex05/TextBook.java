package ex05;

public class TextBook extends Book {

	private BookStatus status;
	
	public TextBook() {
	}

	public TextBook(String id, Long price, String publishingCompany, BookStatus status) {
		super(id, price, publishingCompany);
		this.status = status;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TextBook [status=" + status + "]";
	}

}
