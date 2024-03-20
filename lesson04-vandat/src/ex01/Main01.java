package ex01;

import java.util.Arrays;
import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien(101, "van dat", 9f, 8.5f);
		SinhVien sv2 = new SinhVien(102, "van tien", 9f, 9.5f);
		SinhVien sv3 = new SinhVien();
		
		SinhVien[] svs = new SinhVien[] {sv1, sv2, sv3};

		System.out.println("Nhập thông tin sinh viên 3");
		enter(sv3);

		System.out.println("sv1 -> " + sv1);
		System.out.println("sv2 -> " + sv2);
		System.out.println("sv3 -> " + sv3);

		System.out.println("Thông tin sinh viên có điểm trung bình cao hơn 8.5");
		SinhVien[] results = getSvGood(svs);
		for (SinhVien result: results)
			System.out.println(result);

		System.out.println("Thông tin sinh viên có điểm lý thuyết cao hơn điểm thực hành");
		results = getSvLtGood(svs);
		for (SinhVien result: results)
			System.out.println(result);
	}

	private static void enter(SinhVien sv) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập mã sinh viên -> ");
		sv.setId(ip.nextInt());
		System.out.print("Nhập tên sinh viên -> ");
		ip.nextLine();
		sv.setName(ip.nextLine().trim());
		System.out.print("Nhập điểm lý thuyết -> ");
		sv.setScoreLt(ip.nextFloat());
		System.out.print("Nhập diểm thực hành -> ");
		sv.setScoreTh(ip.nextFloat());
		
		ip.close();
	}
	
	private static SinhVien[] getSvGood(SinhVien[] svs) {
		SinhVien[] result = new SinhVien[svs.length];
		int count = 0;
		for (SinhVien sv: svs) {
			if ((sv.getScoreLt() + sv.getScoreTh()) / 2 > 8.5) {
				result[count] = sv;
				count++;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}

	private static SinhVien[] getSvLtGood(SinhVien[] svs) {
		SinhVien[] result = new SinhVien[svs.length];
		int count = 0;
		for (SinhVien sv: svs) {
			if (sv.getScoreLt() > sv.getScoreTh()) {
				result[count] = sv;
				count++;
			}
		}
		return Arrays.copyOfRange(result, 0, count);

	}

}
