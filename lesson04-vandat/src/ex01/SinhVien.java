package ex01;

import java.util.Scanner;

public class SinhVien {

	private int id;
	private String name;
	private float scoreLt;
	private float scoreTh;
	
	public SinhVien() {
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int id, String name, float scoreLt, float scoreTh) {
		this.id = id;
		this.name = name;
		this.scoreLt = scoreLt;
		this.scoreTh = scoreTh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getScoreLt() {
		return scoreLt;
	}

	public void setScoreLt(float scoreLt) {
		this.scoreLt = scoreLt;
	}

	public float getScoreTh() {
		return scoreTh;
	}

	public void setScoreTh(float scoreTh) {
		this.scoreTh = scoreTh;
	}

	@Override
	public String toString() {
		return " [Mã sinh viên: " + id + ", Tên sinh viên: " + name + ""
				+ ", Điểm lý thuyết: " + scoreLt + ", Điểm thực hành: " + scoreTh + "]";
	}
	
}
