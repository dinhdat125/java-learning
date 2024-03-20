package ex04;

import java.time.LocalDate;

public class Main04 {

	public static void main(String[] args) {
		
		GiamDoc gd = new GiamDoc("Nguyen Tien", LocalDate.of(1991, 5, 5), 5.5f, 2f);
		TruongPhong tp1 = new TruongPhong("Nguyen Than", LocalDate.of(1992, 10, 5), 4.5f, 1.5f, "Phong Nhan Su");
		TruongPhong tp2 = new TruongPhong("Le Van Hong", LocalDate.of(1997, 1, 22), 4f, 1.5f, "Phong Ke Toan");
		NhanVien nv1 = new NhanVien("Dinh Dat", LocalDate.of(2000, 11, 15), 3.5f, "Phong Nhan Su", tp1);
		NhanVien nv2 = new NhanVien("Thanh Vu", LocalDate.of(2001, 8, 8), 3f, "Phong Ke Toan", tp2);
		NhanVien nv3 = new NhanVien("Nhat Hung", LocalDate.of(2000, 6, 13), 3.5f, "Phong Ke Toan", tp1);
		NhanVien nv4 = new NhanVien("Tran Toan", LocalDate.of(1997, 11, 16), 3.5f, "Phong Nhan Su", tp2);
		NhanVien nv5 = new NhanVien("Thi Lan", LocalDate.of(1999, 10, 20), 3f, "Phong Nhan Su", tp1);
		NhanVien nv6 = new NhanVien("Van Tai", LocalDate.of(2003, 2, 4), 2.5f, "Phong Ke Toan", tp1);
		
		People[] peoples = {gd, tp1, tp2, nv1, nv2, nv3, nv4, nv5, nv6};
		
		System.out.println("Thông tin các nhân sự trong công ty:");
		showInfor(peoples);

		System.out.println("\nThống kê số lượng nhân viên của từng Trưởng phòng:");
		statisticalStaffOfManager(peoples);
//		int countTp1 = 0;
//		int countTp2 = 0;
//		for (People people : peoples) {
//			if (people instanceof NhanVien) {
//				if (((NhanVien)people).getTruongPhong() == tp1) {
//					countTp1++;
//				}
//				if (((NhanVien)people).getTruongPhong() == tp2) {
//					countTp2++;
//				}
//			}
//		}
//		System.out.println("Trưởng phòng " + tp1.getHoTen() + " là: " + countTp1);
//		System.out.println("Trưởng phòng " + tp2.getHoTen() + " là: " + countTp2);
		
		System.out.println("\nLương của từng nhân sự:");
		showSalary(peoples);
	}
	
	private static void showInfor(People[] peoples) {
		for (People people : peoples)
			System.out.println(people);
	}
	
	private static void statisticalStaffOfManager(People[] peoples) {
		People[] truongphongs = new TruongPhong[peoples.length];
		int count = 0;
		// đếm có bao nhiêu trưởng phòng -> count
		for (People people : peoples)
			if (people instanceof TruongPhong) {
				truongphongs[count] = people;
				count++;
			}
				
		// cho mảng số nguyên chứa count phần tử
		// giá trị mỗi phần tử là số nhân viên được quản lý bởi từng trưởng phòng tương ứng
		int[] countTp = new int[count];
		
		// đếm số nhân viên được quản lý
		for (People people : peoples) {
			if (people instanceof NhanVien) {
				for (int i = 0; i < count; i++) {
					if (truongphongs[i] == ((NhanVien)people).getTruongPhong())
						countTp[i]++;
				}
			}
		}
		
		for (int i = 0; i < count; i++) {
			System.out.println("Trưởng phòng " + truongphongs[i].getHoTen() + " là: " + countTp[i]);
		}
	}
	
	private static void showSalary(People[] peoples) {
		for (People people : peoples)
			System.out.println(people.tinhLuong());
	}
}
