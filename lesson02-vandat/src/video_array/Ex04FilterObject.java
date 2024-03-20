package video_array;

import java.util.Arrays;

public class Ex04FilterObject {
	public static void main(String[] args) {
		Item itemA = new Item(123, "Item 123", 720);
		Item itemB = new Item(234, "Item 234", 260);
		Item itemC = new Item(345, "Item 345", 100);
		Item[] items = {itemA, itemB, itemC};
		
		Item[] result = filter(items);
//		System.out.println(Arrays.toString(result));
		
		for(Item item: result)	System.out.println(item);
	}
	
	private static Item[] filter(Item[] elements) {
		Item[] result = new Item[elements.length];
		int count = 0;
		for(Item element: elements) {
			if(element.price > 200) {
				result[count] = element;
				count++;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}
}
