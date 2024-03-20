package view.sorting;

import static utils.ArrayUtils.*;

import bean.Item;
import functional.Compare_Item;
import model.DataModel;

public class Ex03BubbleSort_Item {

	public static void main(String[] args) {
		Item[] items = DataModel.mockItem_NullValues();
		
		// Sort items by id - ascending
		sort(items, (i1, i2) -> {
			// null first
			if (i1 == null)
				return 0;
			if (i2 == null)
				return 1;
			return i1.getId() - i2.getId();
		});
		generate("1. Items(sort by id[asc - null first])", items);
		
		// Sort items by name - descending
		sort(items, (i1, i2) -> {
			// null first
			if (i1 == null)
				return 0;
			if (i2 == null)
				return 1;
			if (i1.getName() == null)
				return 0;
			if (i2.getName() == null)
				return 1;
			return i2.getName().compareTo(i1.getName());
		});
		generate("2. Items(sort by name[desc - null first])", items);
		
		// Sort items by storeId - ascending -> price - descending
		sort(items, (i1, i2) -> {
			// null first
			if (i1 == null)
				return 0;
			if (i2 == null)
				return 1;
			
			if (i1.getStoreId() == null)
				return 0;
			if (i2.getStoreId() == null)
				return 1;
			// compare by storeId - asc
			Integer store1 = i1.getStoreId();
			Integer store2 = i2.getStoreId();
			if (store1.compareTo(store2) != 0)
				return store1.compareTo(store2);
			
			if (i1.getPrice() == null)
				return 0;
			if (i2.getPrice() == null)
				return 1;
			// compare by price - desc
			return i2.getPrice().compareTo(i1.getPrice());
		});
		generate("3. Items(sort by storeId[asc - null first] -> price[desc - null first])", items);
	}
	
	private static void sort(Item[] items, Compare_Item compareItem) {
		for (int i = 0; i < items.length; i++)
			for (int j = 0; j < items.length - i - 1; j++)
				if (compareItem.compare(items[j], items[j+1]) > 0)
					swap(items, j, j+1);
	}
	
}
