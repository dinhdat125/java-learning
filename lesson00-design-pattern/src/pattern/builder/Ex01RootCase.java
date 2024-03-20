package pattern.builder;

public class Ex01RootCase {

	public static void main(String[] args) {
		/*
		 Design Pattern: là các mẫu thiết kế, được sinh/tạo ra từ các kinh nghiệm của các người đi trước
		 				: giúp mình giải quyết các vấn đề cụ thể
		 Builder Pattern
		 + Đặt vấn đề
		 	Được dùng để tạo ra đối tượng cho các complex class/object
		 	Complex class/object là class có nhiều (>=6) thuộc tính và có rất nhiều mixing constructor từ class này
		 	A: a1, a2, a3, a4, a5, a6
		 	+ constructor()
		 	+ constructor(a1, a2)
		 	+ ...
		 	
		 	-> code rườm rà
		 	-> vì constructor luôn trùng tên với class
		 		vd: càn constructor 2 tham số a1, a2 và cần constructor a5, a6
		 		-> nếu như a1 trùng KDL với a5
		 					a2   " 			a6 -> k thể
		 		xử lý -> dùng duy nhất hàm khởi tạo rỗng , dùng setter để truyền tham số
		 		ok
		 		nhưng -> nếu required 5 tham số thì phải setter 5 lần -> code khá dài cho tạo đối tượng
		 		
		 		=> dùng builder pattern
		 		vd: LocalDateTime: date, month, year, hour, minute, seconds, milliseconds, timezone, ..
		 + Cách thực thi
		 	Thay vì dùng setter -> 1 lần gọi hàm set xong trả về void, lấy đt đó đi gọi lại -> code dài
		 	Dùng builder style 	-> 1 lần gọi hàm set xong thì trả về chính đt hiện tại -> tiếp tục đi gọi các
		
		
		LocalDateTime.now()		//LocalDateTime
			.withHour(21)		//LocalDateTime
			.withMinute(45)		//LocalDateTime
			.withSecond(59);	//LocalDateTime
			
		*/
	}
}
