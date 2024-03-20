package view.inheritance.cclass;

import java.math.BigDecimal;

public class ReferenceBook extends Book {

	private BigDecimal tax;
	
	//khi gọi hàm khởi tạo của KDL con
	//yêu cầu phải gọi đến 1 hàm khởi tạo của KDL cha
	//mặc định gọi hàm super(), nên trong KDL cha nên có 1 hàm khởi tạo rỗng
	
	public ReferenceBook() {
	}

	//super: đại diện cho đối tượng KDL cha -> super.
	//super(...) gọi hàm khởi tạo của cha
	
	//this: đại diện cho đối tượng KDL hiện tại -> this.
	//this(...) gọi hàm khởi tạo của đối tượng hiện tại
	
	public ReferenceBook(String id, String name, String publisher, BigDecimal salesPrice, BigDecimal tax) {
		super(id, name, publisher, salesPrice);
		this.tax = tax;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + tax;
	}
	
}
