package view.operator;

public class Ex01BasicOperatorDemo {
	public static void main(String[] args) {
		int a = 7;
		int b = 7;
		//toán tử && 
		//kq trả về true khi tất cả các biểu thức đều trả về true
		//kq trả về false khi tồn tại 1 biểu thức false, các biểu thức còn lại sẽ k đc thực thi
		
		//toán tử ||
		//kq trả về false khi tất cả các biểu thức trả về false
		//kq trả về true khi tồn lại 1 biểu thức true, các biểu thức còn lại sẽ k đc thực thi
		
//		boolean test = (a++ > 7) && (b++ < 9);
		boolean test = (++a > 7) || (b++ < 9);

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println(test);
	}
}
