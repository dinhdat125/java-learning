package view;

import static utils.Utils.generate;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex05DailyExpenses {

	public static void main(String[] args) {
		var dailyExpenses = mockupData();
		
		generate("Sorted daily expenses by key ascending:", dailyExpenses);
		
		var sortedByValue = dailyExpenses.entrySet()
			.stream()
			.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
			.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
		
		generate("Sorted daily expanses by value descending:", sortedByValue);
	}
	
	private static Map<String, Integer> mockupData() {
		var data = new TreeMap<String, Integer>();
		data.put("eat", 200);
		data.put("gasoline", 50);
		data.put("cafe", 70);
		data.put("work", 150);
		data.put("learn", 90);
		data.put("other", 100);
		return data;
	}
}
