package view.inheritance.iinterface;

public interface Shape {

	/*
	 - Trước JDK 1.8
	 	Hàm trong interface chỉ được phép là hàm trừu tượng
	 	Hàm trừu tượng là hàm chỉ có phần khai báo k có phần thực thi
	 	Mặc định: public abstract
	 	
	 	Thuộc tính trong interface mặc định là public static final và bắt buộc khởi tạo giá trị
	 */
	
	int s = 5;
	
	void paint();
	
	void cals();
}
