package view;

public class Ex04InitialTimeWithStatic_Nonstatic {
	
	//attributes, method
	
	//static		: class loading time
	//non-static	: object creating time
	
	//order time	: static -> non-static
	
	private static String staticVar;
	
	private String nonStaticVar;
	
	public static void main(String[] args) {
		staticMethod();
		
		// nonStaticMethod();	-> need object
	}
	
	private static void staticMethod() {
		System.out.println(staticVar);
		// System.out.println(nonStaticVar);	// k dùng được biến nonStatic
		// nonStaticMethod();					// k thể gọi hàm nonStaticMethod
		System.out.println("Ex04 -> Static Method");
	}
	
	// Ex04 e1 = new Ex04();
	// e1.nonStaticMethod();
	private void nonStaticMethod() {
		System.out.println(nonStaticVar);
		System.out.println(staticVar);
		staticMethod();
		System.out.println("Ex04 -> Non-Static Method");
	}
}
