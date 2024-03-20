package view;

import java.math.BigDecimal;
import java.util.Arrays;
import static java.util.Comparator.*;

import bean.Item;

public class Ex03FindItems {

	public static void main(String[] args) {
		Item[] items = process();
		
		System.out.println("Mặt hàng có giá bán cao nhất của mỗi cửa hàng là:\n"
						+ Arrays.toString(findItemsWithHighestSalesPriceOfEachStore(items)));
	}
	
	private static Item[] findItemsWithHighestSalesPriceOfEachStore(Item[] items) {
		Item[] result = new Item[items.length];
		Arrays.sort(items, 
						comparing(Item::getStoreId).
						thenComparing(Item::getSalesPrice));
		
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			if (i != items.length - 1 && items[i].getStoreId() == items[i+1].getStoreId())
				continue;
			result[count++] = items[i];
		}
		
		return Arrays.copyOfRange(result, 0, count);
	}
	
	private static Item[] process() {
		return new Item[] {
			new Item(1, "A", bd(25), 101),
			new Item(-2, "B", bd(90), 102),
			new Item(3, "C", bd(88), 102),
			new Item(-4, "D", bd(40), 101),
			new Item(5, "E", bd(60), 102),
			new Item(6, "F", bd(18), 101),
		};
	}
	
	private static BigDecimal bd(double value) {
		return new BigDecimal(String.valueOf(value));
	}

	/*
	private static void sort(Item[] items) {
		for (int i = 0; i < items.length; i++)
			for (int j = 0; j < items.length - i - 1; j++) {
				Integer store1 = items[j].getStoreId();
				Integer store2 = items[j+1].getStoreId();
				if (store1.compareTo(store2) > 0) {
					swap(items, j, j+1);
					continue;
				}
				BigDecimal sales1 = items[j].getSalesPrice();
				BigDecimal sales2 = items[j+1].getSalesPrice();
				if (store1.compareTo(store2) == 0 && sales1.compareTo(sales2) > 0)
					swap(items, j, j+1);
			}
	}
	
	private static void swap(Item[] items, int a, int b) {
		Item temp = items[a];
		items[a] = items[b];
		items[b] = temp;
	}
	*/
}
