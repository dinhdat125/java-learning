package ex04;

import java.time.LocalDate;

public class TruongPhong extends People {

	private Float heSoChucVu;
	private String tenDonVi;
	
	public TruongPhong() {
	}

	public TruongPhong(String hoTen, LocalDate ngaySinh, Float heSoLuong, Float heSoChucVu, String tenDonVi) {
		super(hoTen, ngaySinh, heSoLuong);
		this.heSoChucVu = heSoChucVu;
		this.tenDonVi = tenDonVi;
	}

	public Float getHeSoChucVu() {
		return heSoChucVu;
	}

	public void setHeSoChucVu(Float heSoChucVu) {
		this.heSoChucVu = heSoChucVu;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	@Override
	public String toString() {
		return "Truong Phong -> " + super.toString() + ", He So Chuc Vu: " + heSoChucVu + ", Ten Don Vi: " + tenDonVi;
	}
	
	@Override
	long tinhLuong() {
		System.out.print("Truong Phong " + getHoTen() + ": ");
		return (long)((super.getHeSoLuong() + heSoChucVu) * 2200000);
	}
}
