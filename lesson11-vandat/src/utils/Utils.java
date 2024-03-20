package utils;

import java.util.Collection;
import java.util.Map;

public class Utils {
	
	private Utils() {
		
	}
	
	public static <E> void generate(String prefix, Collection<E> elements) {
		System.out.println(prefix + " {");
		elements.forEach(seq -> {
			System.out.println("    " + seq);
		});
		System.out.println("}");
	}
	
	public static <K, V> void generate(String prefix, Map<K, V> map) {
		System.out.println(prefix);
		for (var entry: map.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		System.out.println();
	}
}
