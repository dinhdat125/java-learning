package demomain;

public class Ex01TestMainMethod {
	/*
	 Để thực thi 1 ct trong java
	 + tạo ra 1 class -> tạo ra 1 file .java có tên trùng với tên class
	 + ct
	 	- ctdl: khai báo và lưu trữ dữ liệu
	 	- hàm/phương thức: nơi xử lý 1 chức năng trong chương trình
	 	- hàm main: nơi bắt đầu và kt 1 ct khi thực thi
	 ctrl shift f
	 
	 + access moditier static return_type method_name(parameters){
	 	body }
	 	access modifier: public, private, protected : phạm vi truy cập
	 	static: thuộc phạm vi của class
	 	return_type: kiểu dữ liệu trả về
	 	method_name: tên hàm
	 	parameters: danh sách tham số
	 
	 */
	
	public static void printStarTriangle() {
		System.out.println("*");
		System.out.println("* *");
		System.out.println("* * *");
		System.out.println("* * * *");
		System.out.println("* * * * *");
	}
	
	public static void main(String[] args) {
		System.out.println("Hàm main");
		printStarTriangle();
	}
	
}
