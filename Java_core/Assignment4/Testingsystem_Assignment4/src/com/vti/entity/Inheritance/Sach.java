package com.vti.entity.Inheritance;

public class Sach extends TaiLieuThuVien {
	private int id;
	private String tenTg;
	private int soTrang;

	public Sach(int maTaiLieu, String tenNhaXuatBan, int soPhatHanh, String tenTg,int soTrang) {
		super(maTaiLieu, tenNhaXuatBan, soPhatHanh);
		this.tenTg = tenTg;
		this.soTrang = soTrang;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenTg() {
		return tenTg;
	}

	public void setTenTg(String tenTg) {
		this.tenTg = tenTg;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	
	public void getInfor() {
		super.toString();
		System.out.println(super.toString());
		System.out.println("Ten tac gia: " + tenTg);
		System.out.println("So trang: " + soTrang);
	}

}
