package view.set;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
//import java.util.LinkedHashSet;
//import java.util.TreeSet;

import bean.Item;

public class Ex01BasicSetDemo {

	public static void main(String[] args) {
		
		// set of Integer
		Set<Integer> numbers = new HashSet<>();
		
		numbers.add(220);
		numbers.add(41);
		numbers.add(777);
		numbers.add(39);
		numbers.add(555);
		numbers.add(220); // kiểm tra hashcode, equals giống như map
		// khi gọi hàm add(e) -> gọi hàm map.put(e, PRESENT)
		// e của set chính là key của map, (Object PRESENT = new Object())
		
		System.out.println("Set of numbers:");
		numbers.forEach(number -> System.out.print(number + "  "));
		
		// set of Object
		Set<Item> items = new HashSet<>();

		items.add(new Item(1, "A1", bd(30), 101));
		items.add(new Item(22, "A2", bd(10), 402));
		items.add(new Item(3, "A3", bd(20), 203));
		items.add(new Item(4, "A9", bd(99), 999));
		
		System.out.println("\n\nitems size --> " + items.size());
		items.forEach(item -> System.out.println(item));
	}

	private static BigDecimal bd(double value) {
		return new BigDecimal(String.valueOf(value));
	}
}
