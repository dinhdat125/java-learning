package view;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex02 {

	public static void main(String[] args) {
		String text = "aaaaccdcec";
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < text.length(); i++) {
			if (map.containsKey(text.charAt(i) + "")) {
				map.put(text.charAt(i) + "", map.get(text.charAt(i) + "") + 1);
			} else {
				map.put(text.charAt(i) + "", 1);
			}
		}
		Integer max = map.entrySet().stream()
				.mapToInt(m -> m.getValue())
				.max()
				.getAsInt();
		System.out.println("Ky tu co so lan xuat hien nhieu nhat: " + 
				map.entrySet().stream()
				.filter(m -> m.getValue() == max)
				.map(m -> m.getKey())
				.collect(Collectors.joining(", ")));
	}
}
