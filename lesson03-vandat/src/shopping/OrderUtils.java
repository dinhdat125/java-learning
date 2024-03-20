package shopping;

import java.time.LocalDate;

/*
 * Utility of Order Class
 * No cares created class's object -> private contrustor
 */
public class OrderUtils {
	
	private OrderUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static double export(Order order) {
		double totalOfMoney = 0;
		
		ItemDetail[] ids = order.getItemDetails();
		for (ItemDetail id: ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			
			double idCost = item.getCost() * quantity;
			if (item.getCost() > 590 && LocalDate.of(2023, 5, 5).isEqual(order.getOrderDate().toLocalDate()))
				// isEqual(): kiểm tra ngày tháng năm có bằng nhau k
				// toLocalDate: chuyển sang kiểu LocalDate
				idCost *= 0.9;
			totalOfMoney += idCost;
		}
		
		return totalOfMoney;
	}
}
