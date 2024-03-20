package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import bean.Store;

public class NumberUtils {

	private NumberUtils() {
	}
	
	public static <T> void generate(String prefix, Collection<T> elements) {
		System.out.println(prefix + " {");
		elements.forEach(element -> System.out.println("    " + element));
		System.out.println("}\n");
	}

	public static BigDecimal bd(double val) {
		return BigDecimal.valueOf(val);
	}
	
	public static int countExpectedSalesStoreNotNull(List<Store> data) {
		return data.stream()
				.filter(s -> s.getExpectedSales() != null)
				.toList()
				.size();
	}
	
	public static BigDecimal average(List<Store> data) {
		return sumExpectedSales(data).divide(bd(countExpectedSalesStoreNotNull(data)), 1, RoundingMode.HALF_UP);
	}
	
	public static BigDecimal sumExpectedSales(List<Store> data) {
		return data.stream()
				.filter(s -> s.getExpectedSales() != null)
				.map(Store::getExpectedSales)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public static BigDecimal sumStockPreviousDay(List<Store> data) {
		return data.stream()
				.map(Store::getStockPreviousDay)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public static Integer sumAmountsAllocated(Map<Long, Integer> amountAllocated) {
		return amountAllocated.entrySet().stream()
				.map(Entry::getValue)
				.reduce(0, Integer::sum);
	}
	
	public static BigDecimal max(BigDecimal a, BigDecimal b) {
		return (a.compareTo(b) == 1) ? a : b;
	}
}
