package view.sorting;

import bean.Item;
import functional.Compare_Item;
import model.DataModel;
import static utils.ArrayUtils.*;

public class Ex04SelectionSort_Item {

	public static void main(String[] args) {
		Item[] items = DataModel.mockItem();
		
		// Sort items by id - ascending
		sort(items, (i1, i2) -> i1.getId().compareTo(i2.getId()));
		generate("1. Items(sort by id[asc])", items);
	}
	
	private static void sort(Item[] items, Compare_Item compareItem) {
		for (int i = items.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (compareItem.compare(items[j], items[i]) > 0)
					swap(items, j, i);
			}
		}
	}
}
