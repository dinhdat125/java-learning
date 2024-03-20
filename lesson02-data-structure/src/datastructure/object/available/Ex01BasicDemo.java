package datastructure.object.available;

import datastructure.object.custom.Item;

public class Ex01BasicDemo {
	public static void main(String[] args) {
		//primitive type
		int a=5;
		System.out.println("a -> "+a);
		
		//object type :custom
		Item item1 = new Item();
		Item item2 = new Item(1,'A',10);
		
		//object type
		Integer o1 = new Integer(12); 
		Integer o2 = new Integer(13); 

		System.out.println("o1 -> "+o1);
		System.out.println("o2 -> "+o2);
		
		Integer o3 = 15;
		Integer o4 = 25;
		
		Character c1 = new Character('@');
		Character c2 = '!';
		System.out.println("c1 -> "+c1);
		System.out.println("c2 -> "+c2);
		
		//Để khởi tạo giá trị cho KDL đối tượng
		//Hầu hết sd từ khóa new 
		//Đặc biệt với những KDL có sẵn trong Java(Integer, Long, Stirng, ...) 
		//thì có thể khởi tạo gt k cần dùng từ khóa new
		
	}
}
