package common;

import datastructure.object.custom.Item;

public class Ex04VariableScope {
	
	//cú pháp khai báo biến
	//
	
	//biến toàn cục global variable
	//thuộc tính attributes
	public static int a = 77;
	private static String b = "Title";
	public static double c = 14d;
	
	public static void main(String[] args) {
		//biến cục bộ
		//phạm vi trong hàm main
		// static hoặc public/private int a = 99; error
		int a = 99;
		String b = "welcome";
		Item item = new Item(1,'A',11d);
		
		System.out.println("a local var : " + a);
		System.out.println("a global var : " + Ex04VariableScope.a);
	}
	
	public static void testScope() {
		//biến cục bộ
		//phạm vi trong hàm testScope
		int a = 10;
		String b = "hello";
	}
}
