package a.validation_try_catch_throw_throws;

import java.io.File;
import java.io.IOException;

public class Ex04Exception_ThrowThrows {

	// validation: validation trước đoạn code có khả năng bị exception
	// try-catch: đưa đoạn code có khả năng bị exception vào khối try-catch
	
	// throw_throws
	// throw: ném exception trước khi đoạn code có khả năng bị exception xảy ra
	//		: ném khi mà exception xảy ra hay k phụ thuộc vào param truyền lúc gọi hàm
	// throws: ném compile exception ở chỗ khai báo hàm để nơi gọi hàm này phải xử lý lỗi
	
	// compile, runtime exception
	// trong hàm: nếu mình throw new runtime exception(RE)
	//			thì tại chỗ khai báo hàm k bắt buộc phải throws ra RE
	//			và nếu mình có throws RE thì nó vô nghĩa(RE k bắt buộc phải xử lý tại compile)
	// trong hàm: nếu mình throw new compile exception(CE)
	//			thì tại chỗ khai báo hàm bắt buộc phải throws ra CE
	//			để chỗ gọi hàm biết đc bên trong hàm có CE -> bắt buộc phải xử lý tại compile
	public static void main(String[] args) {
		System.out.println("start");
		try {
			createFile("data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
	
	// path = folder../..filename.ext(txt, jpg, ...)
	private static File createFile(String path) throws IOException {
		File file = new File(path);
		
		if (file.exists())
			System.out.println("File " + file.getName() + " is available");
		
		boolean isSuccess = file.createNewFile();
		
		String message = isSuccess ? "successful" : "failed";

		System.out.println("File " + file.getName() + " is create " + message);
		
		return file;
	}
}
