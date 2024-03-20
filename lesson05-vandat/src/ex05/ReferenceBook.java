package ex05;

public class ReferenceBook extends Book {

	private Float tax;
	
	public ReferenceBook() {
	}

	public ReferenceBook(String id, Long price, String publishingCompany, Float tax) {
		super(id, price, publishingCompany);
		this.tax = tax;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "ReferenceBook [tax=" + tax + "]";
	}

}
