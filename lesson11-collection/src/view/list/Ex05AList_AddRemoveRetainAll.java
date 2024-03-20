package view.list;

import java.util.ArrayList;
import java.util.List;

import static utils.CollectionUtils.generate;

public class Ex05AList_AddRemoveRetainAll {

	public static void main(String[] args) {
		var listA = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		var listB = new ArrayList<>(List.of(4, 5, 6, 7, 8));
		
		var list1 = new ArrayList<>(listA);
		list1.addAll(listB);
		generate("list1 add all", list1); // phép hợp
		
		var list2 = new ArrayList<>(listA);
		list2.removeAll(listB);
		generate("list2 remove all", list2); // phép hiệu
		
		var list3 = new ArrayList<>(listA);
		list3.retainAll(listB);
		generate("list3 retain all", list3); // phép giao
	}
}
