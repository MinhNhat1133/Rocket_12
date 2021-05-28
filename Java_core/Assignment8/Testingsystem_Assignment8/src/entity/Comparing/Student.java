package entity.Comparing;

import java.time.LocalDate;

public class Student {
	private int id;
	private String ten;
	private LocalDate ngaySinh;
	private float diem;

	public Student(int id, String ten, LocalDate ngaySinh, float diem) {
		this.id = id;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.diem = diem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "\n id: " + id + "||" + "ten: " + ten + "||" + "Ngay Sinh: " + ngaySinh+  "||" + "Diem: " + diem  ;
	}

	

}