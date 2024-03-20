package common;

import datastructure.object.custom.Item;

public class Ex01Final {
	public static void main(String[] args) {
		
		//Final -> Final ở stack : k thể thay đổi giá trị cho biến ở stack
		
		//primitive type
		//giá trị lưu trữ ở stack 
		//biến lưu ở stack chứa thông tin giá trị
		
		final int a = 5;
		int b = 7;
		int c =10;
		
		//a=b;
		//a=10;
		b=c;
		
		//Object type
		//giá trị lưu trữ ở heap
		//biến lưu ở stack chứa thông tin địa chỉ ô nhớ ở heap
		
		Item itA = new Item(1,'A',11);
		final Item itB = new Item(2,'B',22);
		Item itC = new Item(3,'C',33);
		
		itA = itB;
		//itB = itA;
		itB.name = 'Z';
		
	}
}
