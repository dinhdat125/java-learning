package view.list;

import java.math.BigDecimal;
import bean.Item;
import model.DataModel;

import static utils.CollectionUtils.generateItems;
import static java.util.Comparator.*;

public class Ex04AList_Item {

	// remove:
	// --> Duyệt từng phần tử trong list, nếu phần tử nào 'equals'
	// với phần tử cần remove --> remove
	// --> chỉ remove phần tử đầu tiên equals với phần tử cần xóa
	
	// lúc compile --> luôn gọi hàm equals của Object --> luôn compare địa chỉ
	// lúc runtime --> gọi hàm equals của class mình truyền vào --> nên phải override hàm equals
	
	// contains:
	// --> Duyệt từng phần tử trong list, nếu phần tử nào 'equals'
	// với phần tử đang kiểm tra --> true
	
	// ---> phải override lại hàm equals của class mình truyền vào List
	// để thay vì equals theo địa chỉ(mặc định từ class Object) thì nó sẽ
	// equals theo giá trị của thuộc tính mình override
	
	// khi tạo class -> tạo attribute, constructor, getter, setter, toString và equals
	// vì List: remove, contains có dùng equals
	
	public static void main(String[] args) {
		
		var items = DataModel.mockItem();
		
		Item itemToBeRemove = new Item(7,  "Item C1", bd("91"), 102);
		items.remove(itemToBeRemove);
		
		// sorting tương tự Arrays
		// collection -> sort(List<T> list)
		//			  -> sort(List<T> list, Comparator<? super T> c)
		
		// list.sort(Comparator<? super T> c)
		// -> sort items by storeId(ASC), price(DESC)
		items.sort(comparing(Item::getStoreId)
					.thenComparing(Item::getPrice, reverseOrder()));
		
		generateItems("items", items);
	}
	
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
}
