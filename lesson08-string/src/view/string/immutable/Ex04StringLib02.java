package view.string.immutable;

public class Ex04StringLib02 {

	public static void main(String[] args) {
		String s = " cheers   from da    nang";
		
		// kiểm tra chuỗi s1 có phải là chuỗi bắt đầu hay kết thúc trong chuỗi s k?
		System.out.println("start with hello -> " + s.startsWith("hello"));
		System.out.println("start with ch -> " + s.startsWith("ch"));
		
		System.out.println("end with ang -> " + s.endsWith("ang"));
		
		// thay thế chuỗi s1 bằng chuỗi s2 trong chuỗi s
		s = s.replace("from", "to");
		System.out.println("s with replace: " + s);
		
		// loại bỏ các khoảng trắng thừa của chuỗi
		s = s.strip().replaceAll("\\s+", " ");
		System.out.println("s with replace all: " + s);
		
		// tạo chuỗi con của chuỗi s bắt đầu từ vị trí số 2
		String sub = s.substring(2);
		System.out.println("sub string -> " + sub);	// eers...
		
		// xác định chuỗi s2 có tồn tại trong chuỗi s1 hay k?
		System.out.println("string contains: " + s.contains("dam"));
	}
}
