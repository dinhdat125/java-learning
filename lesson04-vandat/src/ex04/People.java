package ex04;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class People {

	private String hoTen;
	private LocalDate ngaySinh;
	private Float heSoLuong;
	
	public People() {
	}

	public People(String hoTen, LocalDate ngaySinh, Float heSoLuong) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.heSoLuong = heSoLuong;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(Float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	@Override
	public String toString() {
		return "HoTen: " + hoTen + ", Ngay Sinh: " + ngaySinh + ", He So Luong: " 
				+ heSoLuong;
	}
	
	abstract long tinhLuong();
}
