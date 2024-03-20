package a.validation_try_catch_throw_throws;

import exception.InvalidImageException;

public class Ex05Exception_Custom {

	/*
	 Kiểm tra tính hợp lệ của hình ảnh
	 	+ tên file
	 	+ đuôi file ( jpg, png, svg, jpeg )	 
	 */
	private static String[] imageExtensions = {"jpg", "png", "jpeg", "svg"};
	
	public static void main(String[] args) {
		String[] files = {"hello.jpg", "toi.png", "test.txt", "hoc.jpeg"};
		
		for (String file:files) {
			if (!isValid(file)) {
				try {
					throw new InvalidImageException("File ' " + file + " ' is an invalid image !");
				} catch (InvalidImageException e) {
					System.out.println("e -> " + e.getMessage());
				}
			} else	System.out.println("Uploaded file ' " + file + " ' success");
		}
 	}

	private static boolean isValid(String file) {
		for (String ext:imageExtensions) {
			if (file.endsWith(ext))		// kiểm tra chuỗi file có kết thúc bằng chuỗi ext hay k?
				return true;
		}
		return false;
	}
	
}
