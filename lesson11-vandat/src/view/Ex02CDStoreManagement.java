package view;

import static java.util.Comparator.*;
import static utils.Utils.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

import bean.CD;

public class Ex02CDStoreManagement {

	public static void main(String[] args) {
		var listCD = mockCDs();
		
		add(listCD, new CD(7, "Loại 3", "Ca sĩ H", 3, bd(25.5d)));
		
		generate("1.CD", listCD);
		System.out.println("2.Quantity -> " + listCD.size());
		System.out.println("3.Total price -> " + totalPrice(listCD));
		
		sort(listCD, comparing(CD::getPrice, reverseOrder()));
		generate("4.Sort CD by price descending", listCD);
		
		sort(listCD, comparing(CD::getId));
		generate("5.Sort CD by Id ascending", listCD);
	}
	
	private static void add(Set<CD> listCD, CD cd) {
		listCD.add(cd);
		System.out.println("Added successfully");
	}
	
	private static BigDecimal totalPrice(Set<CD> listCD) {
		BigDecimal total = bd(0d);
		for (CD cd: listCD) {
			total = total.add(cd.getPrice());
		}
		return total;
	}
	
	private static void sort(Set<CD> listCD, Comparator<CD> comparator) {
		// Convert Set -> List
		var alistCD = new ArrayList<CD>(listCD);
		// Sort list by comparator
		alistCD.sort(comparator);
		// Remove all elements in set -> copy elements from sorted list to set
		listCD.removeAll(listCD);
		for (CD aCD: alistCD)
			listCD.add(aCD);
	}
	
	private static Set<CD> mockCDs() {
		var listCD = new LinkedHashSet<CD>();
		listCD.add(new CD(112, "Loại 1", "Ca sĩ A", 2, bd(15.6d)));
		listCD.add(new CD(21, "Loại 1", "Ca sĩ B", 4, bd(25.3d)));
		listCD.add(new CD(30, "Loại 2", "Ca sĩ C", 1, bd(5.6d)));
		listCD.add(new CD(400, "Loại 3", "Ca sĩ D", 2, bd(14d)));
		listCD.add(new CD(5, "Loại 2", "Ca sĩ E", 5, bd(55.6d)));
		listCD.add(new CD(666, "Loại 4", "Ca sĩ G", 3, bd(35.2d)));
		return listCD;
	}
	
	private static BigDecimal bd(Double d) {
		return new BigDecimal(String.valueOf(d));
	}
}
