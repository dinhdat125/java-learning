package view.string.immutable;

public class Ex02StringCompare {

	public static void main(String[] args) {
		// so sánh lớn, bé -> compareTo, vì String implements Comparable<?>
		
		String s1 = "hello";
		String s2 = "keen";
		String s3 = "hello";
		String s4 = new String("hello");
		
		System.out.println("s1 compareTo s2 -> " + s1.compareTo(s2));	// -3, vì h > k -> -3
		
		// so sánh bằng -> equals, từ class Object
		
		// Object#equals: so sánh == -> so sánh địa chỉ (stack)
		// String#equals: so sánh giá trị của String ở heap
		Ex02StringCompare o1 = new Ex02StringCompare();
		Ex02StringCompare o2 = new Ex02StringCompare();
		
		System.out.println("o1 equals o2 -> " + o1.equals(o2)); // false
		System.out.println("s1 equals s3 -> " + s1.equals(s3)); // true
		System.out.println("s1 equals s4 -> " + s1.equals(s4)); // true
	}
}
