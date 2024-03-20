package view.inheritance.cclass;

import java.math.BigDecimal;

public class Book {

	private String id;
	private String name;
	private String publisher;
	private BigDecimal salesPrice;
	
	public Book() {
	}

	public Book(String id, String name, String publisher, BigDecimal salesPrice) {
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.salesPrice = salesPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + publisher + ", " + salesPrice;
	}
	
}
