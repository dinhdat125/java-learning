package view.list;

//import java.util.ArrayList;
//import java.util.List;

public class Ex01RawType {

	public static void main(String[] args) {
		/*
		 Nếu gọi, sử dụng class/interface có tham số là generic type
		 -> Phải truyền giá trị cho tham số đó: là 1 KDL đối tượng
		 -> Nếu mình k truyền KDL vào -> mặc định Object -> raw type
		 
		 Raw type -> dễ bị lỗi casting exception lúc runtime -> lỗi k mong muốn
		 
		 JDK 1.5: auto boxing, auto unboxing
		 		: generic type 1.7(enhancement)
		 
		 
		// JDK 1.5
		List listA = new ArrayList();
		
		listA.add(1);
		listA.add(2);
		listA.add("3");
		listA.add("a3");
		
		for (Object element: listA)
			System.out.println(Integer.parseInt(element.toString()) * 2);
		// --> 2	4	6	NumberFormatException
		
		// JDK 1.7
		List<String> listB = new ArrayList<>();
		
		*/
	}
}
