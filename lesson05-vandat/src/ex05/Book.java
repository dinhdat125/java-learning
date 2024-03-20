package ex05;

public class Book {

	private String id;
	private Long price;
	private String publishingCompany;
	
	public Book() {
	}

	public Book(String id, Long price, String publishingCompany) {
		this.id = id;
		this.price = price;
		this.publishingCompany = publishingCompany;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", price=" + price + ", publishingCompany=" + publishingCompany + "]";
	}
	
}
