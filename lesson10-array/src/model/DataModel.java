package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bean.Item;

public class DataModel {

	private DataModel() {
	}
	
	public static Item[] mockItem() {
		return new Item[] {
				new Item(11, "item B11", bd("17"), 1, dt("28/11/2023 11:22:33")),
				new Item(14, "item Y14", bd("18"), 1, dt("18/01/2023 11:22:33")),
				new Item(21, "item V21", bd("13"), 2, dt("20/11/2023 14:22:33")),
				new Item(19, "item H19", bd("15"), 2, dt("02/10/2023 21:22:33")),
				new Item(9, "item A1", bd("16"), 1, dt("08/11/2023 08:22:33")),
				new Item(32, "item S32", bd("17"), 5, dt("21/11/2023 10:22:33"))			
			};
	}
	
	public static Item[] mockItem_NullValues() {
		return new Item[] {
				null,
				new Item(11, "item B11", null, 1, dt("28/11/2023 11:22:33")), //bd("17")
				new Item(14, "item Y14", bd("18"), 1, dt("18/01/2023 11:22:33")),
				new Item(21, "item V21", bd("13"), 2, dt("20/11/2023 14:22:33")),
				null,
				new Item(19, "item H19", bd("15"), 2, dt("02/10/2023 21:22:33")),
				new Item(9, null, bd("16"), 1, dt("08/11/2023 08:22:33")),
				new Item(32, "item S32", bd("17"), 5, dt("21/11/2023 10:22:33"))			
			};
	}
	
	private static LocalDateTime dt(String value) {
		return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
	
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
}
