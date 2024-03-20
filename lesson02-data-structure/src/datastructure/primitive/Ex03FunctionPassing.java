package datastructure.primitive;

public class Ex03FunctionPassing {
	public static void main(String[] args) {
		//
		
		int a=22;
		int b=37;
		
		// pass by value
		// truyền tham số qua hàm --> truyền giá trị STACK qua cho tham số
		
		modify(a);
		b=a;
		System.out.println("a : "+a); //22
		System.out.println("b : "+b); //22
	}
	
	private static void modify(int a) {
		a=99;
	}
}
