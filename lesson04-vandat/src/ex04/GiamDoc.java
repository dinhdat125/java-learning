package ex04;

import java.time.LocalDate;

public class GiamDoc extends People {

	private Float heSoChucVu;
	
	public GiamDoc() {
	}

	public GiamDoc(String hoTen, LocalDate ngaySinh, Float heSoLuong, Float heSoChucVu) {
		super(hoTen, ngaySinh, heSoLuong);
		this.heSoChucVu = heSoChucVu;
	}

	public Float getHeSoChucVu() {
		return heSoChucVu;
	}

	public void setHeSoChucVu(Float heSoChucVu) {
		this.heSoChucVu = heSoChucVu;
	}

	@Override
	public String toString() {
		return "Giam Doc -> " + super.toString() + ", He So Chuc Vu: " + heSoChucVu;
	}
	
	@Override
	long tinhLuong() {
		System.out.print("Giam Doc " + getHoTen() + ": ");
		return (long)((super.getHeSoLuong() + heSoChucVu) * 3000000);
	}
}
