package view.sorting.available.method;

import java.util.Arrays;
import java.util.Comparator;

import bean.Item;
import model.DataModel;
import static utils.ArrayUtils.*;

public class Ex02QuickSort_Item {

	public static void main(String[] args) {
		Item[] items = DataModel.mockItem();
		
		// sort array of objects[Integer, Double, Item, ...]
		/*
		 Cách 1: Arrays.sort(Object[] a)
		 + Lúc compile a là mảng kiểu Object -> lúc runtime có thể nhận vào bất kỳ KDL đối tượng nào
		 + Để biết được mảng a sắp xếp tăng dần hay giảm dần theo thuộc tính nào
		 	Lúc runtime, kiểm tra KDL của mảng a (Object) có phải là KDL con của interface Comparable<?> hay k
		 	- Nếu class(KDL) truyền vào là con của Comparable<?> 
		 		-> compile: hàm sort đc gọi từng compareTo của Comparable<?>
		 		-> runtime: dựa vào hàm compareTo(Object o) trong đó:
		 					. this là phần tử đứng trước(leftmark)
		 					. o là phần tử đứng sau(rightmark)
		 					-> để biết công thức sort là gì
		 	- Nếu k phải là con của Comparable<?> -> báo lỗi cast exception lúc runtime
		 */
		
		Arrays.sort(items);
		generate("1. Sort items by price(asc)", items);
		
		// generate("1. Sort items by price(asc)", items);
		// phải remove sort ở TH 1
		
		// Hạn chế của Arrays.sort(Object[] a)
		// 1. Bắt lỗi casting tại runtime
		// 2. Mỗi KDL của mảng chỉ đc phép có 1 phương pháp sort
		//		Vì sort phụ thuộc vào override compareTo trong class truyền vào 
		
		/*
		 Comparator<?> 	-> Compare_Item
		 Cách 2: Arrays.sort(T[] a, Comparator<? super T> c)
		 
		 T nếu có implements Comparator<?> vẫn ưu tiên Comparator
		 */
		
		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item i1, Item i2) {
				return i1.getPrice().compareTo(i2.getPrice());
			}
		});
		generate("2. Sort items by price(asc)", items);
		
		Arrays.sort(items, (i1, i2) -> {
			if (i1.getStoreId().compareTo(i2.getStoreId()) != 0)
				return i1.getStoreId().compareTo(i2.getStoreId());
			return i2.getCreateAt().compareTo(i1.getCreateAt());
		});
		generate("3. Sort items by storeId(asc), createdAt[desc]", items);
		
	}
}
