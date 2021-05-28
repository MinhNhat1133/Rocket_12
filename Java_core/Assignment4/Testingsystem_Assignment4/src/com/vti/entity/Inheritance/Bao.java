package com.vti.entity.Inheritance;


public class Bao extends TaiLieuThuVien{

	private int id;
	private byte ngayPhatHanh; 

	public Bao(int maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh,byte ngayPhatHanh) {
		super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(byte ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}
	
	public void getInfor() {
		super.toString();
		System.out.println(super.toString());
		System.out.println("Ngay phat hanh: " + ngayPhatHanh);
	}
}
