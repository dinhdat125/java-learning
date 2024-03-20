package ex04;

import java.time.LocalDate;

public class NhanVien extends People {

	private String tenDonVi;
	private TruongPhong truongPhong;
	
	public NhanVien() {
	}

	public NhanVien(String hoTen, LocalDate ngaySinh, Float heSoLuong, String tenDonVi, TruongPhong truongPhong) {
		super(hoTen, ngaySinh, heSoLuong);
		this.tenDonVi = tenDonVi;
		this.truongPhong = truongPhong;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}

	@Override
	public String toString() {
		return "Nhan Vien -> " + super.toString() + ", Ten Don Vi: " 
				+ tenDonVi + ", Truong Phong: " + truongPhong.getHoTen();
	}

	@Override
	long tinhLuong() {
		System.out.print("Nhan Vien " + getHoTen() + ": ");
		return (long)(super.getHeSoLuong() * 1250000);
	}
	
}
