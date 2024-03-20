package view.sorting.available.method;

import bean.Item;
import model.DataModel;
import java.util.Arrays;
import static utils.ArrayUtils.*;
import static java.util.Comparator.*;

public class Ex03QuickSort_Item_SimpleCases {

	/*
	 Với những trường hợp đơn giản như
	 + sx tăng/giảm theo 1 hoặc nhiều thuộc tính
	 + null first, null last cho elements
	 -> Áp dụng sort có sẵn
	 
	 Với những trường hợp
	 + sx đk if else phức tạp theo logic
	 + null first, null last cho thuộc tính của elements
	 */
	public static void main(String[] args) {
		Item[] items = DataModel.mockItem_NullValues();
		
		// Arrays.sort(items, (c1, c2) -> c1.getPrice().compareTo(c2.getPrice()));
		
		// Function<T, R> f = (T t) -> t.getAttr(); -> lambda expression
		// Function<T, R> f = Item::getAttr; 		-> method reference
		
		Arrays.sort(items, 
				nullsLast(comparing(Item::getStoreId)
				.thenComparing(Item::getCreateAt, reverseOrder()))
		);
		generate("1. Sort items by storeId(asc), createdAt(desc)", items);
	}
}
