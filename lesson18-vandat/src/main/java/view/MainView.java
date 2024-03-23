package view;

import java.time.LocalDate;
import java.util.List;

import persistence.entities.Item;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import static utils.CollectionUtils.generate;

public class MainView {

	private static ItemService itemService;
	private static ItemGroupService itemGroupService;
	
	static {
		itemService = new ItemServiceImpl();
		itemGroupService = new ItemGroupServiceImpl();
	}
	public static void main(String[] args) {
		generate("1. Liệt kê các mặt hàng được bán trong ngày ?", 
				itemService.getItemsBySalesDate(LocalDate.of(2023, 2, 15)));
		
		generate("2. Liệt kê số lượng hàng tồn kho trong mỗi loại hàng",
				itemGroupService.getAmountItemsByItemGroup());
		
		generate("3.1 Liệt kê Tên top 3 mặt hàng được bán nhiều nhất trong năm ?",
				itemService.getTopThreeMostItemsOfYear(2023));
		
		generate("3.2 Liệt kê Tên top 3 mặt hàng được bán nhiều nhất trong năm ?",
				itemService.getTopThreeMostItemsOfYearSolution2(2023));
		
		generateItem("4. Liệt kê danh sách các mặt hàng của mỗi loại hàng", itemService.getAll());
	}
	
	public static void generateItem(String prefix, List<Item> elements) {
		System.out.println(prefix + " -> {");
		elements.forEach(e -> System.out.println("    " + e + "   group -> " + e.getGroup()));
		System.out.println("}");
	}
}
