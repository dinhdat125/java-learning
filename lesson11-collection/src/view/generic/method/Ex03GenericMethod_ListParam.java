package view.generic.method;

import java.util.List;

import bean.Item;
import model.DataModel;

public class Ex03GenericMethod_ListParam {

	public static void main(String[] args) {
		// Write program to print all elements from List
		
		// Handle with array of elements
		List<Integer> lOIntegers = List.of(1, 5, 8, 4, 2, 10);
		List<Double> lODoubles = List.of(2.2d, 7.4d, 4.6d, 8.8d);
		List<String> lOStrings = List.of("a", "d", "b", "c");
		List<Item> lOItems = DataModel.mockItem();
		
//		System.out.println("--- print list using oop polymorphism ---");
//		printList_UsingOop(lOIntegers);
//		printList_UsingOop(lODoubles);
//		printList_UsingOop(lOStrings);
		// --> Error
		
		System.out.println("--- print list using generic method ---");
	    printList_UsingGeneric(lOIntegers);
	    printList_UsingGeneric(lODoubles);
	    printList_UsingGeneric(lOStrings);
	    printList_UsingGeneric(lOItems);
	}
	
	// Integer[], Double[], String[] là con của Object[] --> áp dụng oop
	// List<Integer>, List<Double>, List<String> không phải là con của List<Object>
	
	// Đa hình trong đối tượng --> Failed
	// Cha = Con
//	public static void printList_UsingOop(List<Object> objects) {
//		for (Object object: objects) {
//			System.out.print(object + " ");
//		}
//		System.out.println();
//	}
	
	// Sử dụng generic method
	// <E>: generic type, tự định nghĩa, mặc định nó là KDL đối tượng
	//    : phạm vi sử dụng trong hàm nó khai báo
	//    
	public static <E> void printList_UsingGeneric(List<E> es) {
		for (E e: es) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

}