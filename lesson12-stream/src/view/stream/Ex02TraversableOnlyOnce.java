package view.stream;

import java.util.List;
import java.util.stream.Stream;

public class Ex02TraversableOnlyOnce {

	public static void main(String[] args) {
		/*
		 Stream chỉ cho phép duyệt 1 lần duy nhất --> nếu lặp lại --> throw exception
		 Mục đích: Dùng stream để xử lý, gọi các hàm xử lý thay vì lưu trữ dữ liệu
		 Lưu trữ: Array, Collection
		 Xử lý: Stream
		 
		 Collection: External iteration
		 Stream    : Internal iteration
		 */

		var sequences = List.of("a", "b", "c", "d");
		
		Stream<String> stream = sequences.stream();
		
		stream.forEach(System.out::print);
		
		System.out.println("\n============================\n");
		
		stream.forEach(System.out::print); 
		// IllegalStateException: stream has already been operated upon or closed
	}
}
