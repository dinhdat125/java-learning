package datastructure.object.available;

public class Ex02DiffInitialValue {
	public static void main(String[] args) {
		//Integer demo
		
		//khởi tạo với từ khóa new -> gt sẽ lưu trữ ở vùng nhớ heap
		Integer io1 = new Integer(24);
		Integer io2 = new Integer(36);
		Integer io3 = new Integer(24);
		Integer io4 = new Integer(18);

		System.out.println("io1(" + io1 + ") --> address("	+ System.identityHashCode(io1) + ")");
		System.out.println("io2(" + io1 + ") --> address("	+ System.identityHashCode(io2) + ")");
		System.out.println("io3(" + io1 + ") --> address("	+ System.identityHashCode(io3) + ")");
		System.out.println("io4(" + io1 + ") --> address("	+ System.identityHashCode(io4) + ")");

		//khởi tạo trực tiếp k dùng từ khóa new -> gt sẽ lưu trữ ở vùng nhớ heap/constant pool
		//kiểm tra xem giá trị chuẩn bị khởi tạo đã tồn tại trên constant pool chưa:
		// + nếu chưa tồn tại thì tạo ô nhớ chứa và gán địa chỉ về cho biến (stack)
		// + nếu đã tồn tại thì lấy địa chỉ của ô nhớ đã tồn tại gán về cho biến (stack)
		Integer i5 = 17;
		Integer i6 = 28;
		Integer i7 = 11;
		Integer i8 = 17;
		
		System.out.println("i5(" + io1 + ") --> address("	+ System.identityHashCode(i5) + ")");
		System.out.println("i6(" + io1 + ") --> address("	+ System.identityHashCode(i6) + ")");
		System.out.println("i7(" + io1 + ") --> address("	+ System.identityHashCode(i7) + ")");
		System.out.println("i8(" + io1 + ") --> address("	+ System.identityHashCode(i8) + ")");


		//String demo
		
	}
}
