package utils;

import java.util.Collection;

public class CollectionUtils {

	private CollectionUtils() {
	}
	
	public static <E> void generate(String prefix, Collection<E> elements) {
		System.out.println(prefix + " -> {");
		elements.forEach(e -> System.out.println("    " + e));
		System.out.println("}");
	}

	public static void generate(String prefix, Object object) {
		System.out.println(prefix + " -> {");
		System.out.println("    " + object);
		System.out.println("}");
	}
}
