package view.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import bean.Dish;
import common.Category;
import model.DataModel;

import static utils.StreamUtils.generate;;

public class Ex01BasicDemo {

	public static void main(String[] args) {
		var menu = DataModel.mockDishes();
		
		// non-stream
		var dishes = getData(menu, d -> d.getCalories() > 1000);
		generate("1. Get dishes which have calories > 250(non-stream)", dishes);
		
		// stream
		dishes = menu.stream()                       // Stream<Dish>: 12 dishes
				.filter(d -> d.getCalories() > 1000) // Stream<Dish>: 2 dishes
				.collect(Collectors.toList());       // List<Dish>
		generate("1. Get dishes which have calories > 250(stream)", dishes);
		
		var nameOfDishes = menu.stream()
				.map(Dish::getName)
				.collect(Collectors.toCollection(LinkedHashSet::new));
		generate("2. Get name of dishes", nameOfDishes);
		
		var veggieDishes = menu.stream()	// Stream<Dish>
				.filter(d -> Category.VEGGIE.equals(d.getCategory())) // Stream<Dish>
				.map(Dish::getName)         // Stream<String>
				.toArray(String[]::new);    // String[]
				// if using .toArray(no parameter) --> Object[]
		generate("3. Get name of veggie dishes", veggieDishes);
		
		var weekdays = DataModel.mockWeekdays();
		
		// non-stream: map<k, v> -> set<entry<k, v> -> list<entry<k, v>>   *** sort *** -> linkedhashmap<k, v>
		//     stream: map<k, v> -> set<entry<k, v> -> stream<entry<k, v>> *** sort *** -> linkedhashmap<k, v>
		
		// stream<T> -> collect(Collectors.toList()) -> list<T>
		// stream<T> -> collect(Collectors.toMap(keyMapper, valueMapper))  -> map<k,v> : hashmap
		// stream<T> -> collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction, mapFactory))  -> map<k,v> : hashmap
		
		// mergeFunction -> if key duplicate (ex store1) -> choose item1/item2
		// item1, store1
		// item2, store1
		// item3, store3
		
		var sortedEntries = weekdays.entrySet()
				.stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
		generate("4. Sorted Map demo", sortedEntries.entrySet());
	}
	
	private static List<Dish> getData(List<Dish> menu, Predicate<Dish> predicate) {
		var result = new ArrayList<Dish>();
		for (var dish: menu) {
			if (predicate.test(dish))
				result.add(dish);
		}
		return result;
	}
}
