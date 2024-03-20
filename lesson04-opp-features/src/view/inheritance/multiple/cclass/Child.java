package view.inheritance.multiple.cclass;

public class Child extends Father /* extends Mother */{

	// java k hỗ trợ đa thừa kế
	// vì có trường hợp các class cha có chung hàm khai báo
	// nếu class con k bắt buộc override hàm từ cha
	
	//-> khi lấy con gọi hàm chung thì sẽ k biết gọi đến class nào
	//compile error
	
	public static void main(String[] args) {
		Child c1= new Child();
		c1.cooking();
		c1.running();
		
	}
}
