package view.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import utils.CollectionUtils;
import static java.util.Comparator.*;

public class Ex03MapSorted {

	public static void main(String[] args) {
		// sort by key
		// Map<K, V> map = new TreeMap<>(); --> K implements Comparable<K>
		// Map<K, V> map = new TreeMap<>(Comparator<K>);
		
		// sort by value
		var models = mockData();
		
		// comparing(e -> e.getValue(), reverseOrder()) = Entry.comparingByValue(reverseOrder())
		var sortedMap = sort(models, Entry.comparingByValue(reverseOrder()));
		
		CollectionUtils.generate("Sorting Map", sortedMap);
	}
	
	private static <K, V> Map<K, V> sort(Map<K, V> map, Comparator<Entry<K, V>> comparator){
		// B1: Convert Map<K, V> -> Set<Entry<K, V>> -> List<Entry<K, V>>
		var modelsList = new ArrayList<>(map.entrySet());
		// ~ List<Entry<K, V>> modelsList = new ArrayList<>(map.entrySet());
		
		// B2: Sort list by entry's properties (sort by value desc)
		modelsList.sort(comparator);
		
		// B3: Copy elements(to be sorted) from list to new map
		var sortedMap = new LinkedHashMap<K, V>();
		// ~ Map<K, V> ms = new LinkedHashMap<>();
		for (var entry: modelsList)  // var = Entry<K, V>
			sortedMap.put(entry.getKey(), entry.getValue());
		
		return sortedMap;
	}
	
	private static Map<Integer, String> mockData() {
		Map<Integer, String> models = new HashMap<>();
		models.put(92, "Quảng Nam");
		models.put(43, "Đà Nẵng");
		models.put(75, "Thừa Thiên Huế");
		models.put(74, "Quảng Trị");
		models.put(73, "Quảng Bình");
		return models;	
	}
}
