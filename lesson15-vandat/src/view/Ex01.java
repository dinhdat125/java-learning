package view;

import java.util.HashMap;
import java.util.Map;

public class Ex01 {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 5, 5, 3, 1 };
		Map<Integer, Integer> mapNumbers = new HashMap<>();
		for (int number: numbers) {
			if (!mapNumbers.containsKey(number)) {
				mapNumbers.put(number, 1);
			} else {
				mapNumbers.put(number, 2);
			}
		}
		System.out.print("Phan tu chỉ xuat hien 1 lan: ");
		mapNumbers.entrySet().stream()
			.filter(m -> m.getValue() == 1)
			.map(m -> m.getKey())
			.toList()
			.forEach(number -> System.out.print(number + "  "));
		
		System.out.print("\nPhan tu chỉ xuat hien nhieu hon 1 lan: ");
		mapNumbers.entrySet().stream()
			.filter(m -> m.getValue() > 1)
			.map(m -> m.getKey())
			.toList()
			.forEach(number -> System.out.print(number + "  "));
	}
}
