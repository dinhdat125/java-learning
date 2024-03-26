package shopping;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Order {
	private Customer customer;
	private ItemDetail[] itemDetails;
	private LocalDateTime orderDate;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Customer customer, ItemDetail[] itemDetails, LocalDateTime orderDate) {
		this.customer = customer;
		this.itemDetails = itemDetails;
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ItemDetail[] getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ItemDetail[] itemDetails) {
		this.itemDetails = itemDetails;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", itemDetails=" + Arrays.toString(itemDetails) + ", orderDate="
				+ orderDate + "]";
	}

//	public double export() {
//		double totalOfMoney = 0;
//		
//		ItemDetail[] ids = getItemDetails();
//		for (ItemDetail id: ids) {
//			Item item = id.getItem();
//			int quantity = id.getQuantity();
//			
//			double idCost = item.getCost() * quantity;
//			if (item.getCost() > 590 && LocalDate.of(2023, 5, 5).isEqual(getOrderDate().toLocalDate()))
//				// isEqual(): kiểm tra ngày tháng năm có bằng nhau k
//				// toLocalDate: chuyển sang kiểu LocalDate
//				idCost *= 0.9;
//			totalOfMoney += idCost;
//		}
//		
//		return totalOfMoney;
//	}
	
	
}