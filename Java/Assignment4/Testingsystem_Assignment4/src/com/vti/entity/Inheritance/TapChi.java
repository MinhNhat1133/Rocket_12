package com.vti.entity.Inheritance;

public class TapChi extends TaiLieuThuVien {
	private int id;
	private int soPhatHanh;
	private byte thangPhatHanh;

	public TapChi(int maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, int soPhatHanh, byte thangPhatHanh) {
		super(maTaiLieu, tenNhaXuatBan, soPhatHanh);
		this.soPhatHanh = soPhatHanh;
		this.thangPhatHanh = thangPhatHanh;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(int soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public short getThangPhatHanh() {
		return thangPhatHanh;
	}

	public void setThangPhatHanh(byte thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}

	public void getInfor() {
		super.toString();
		System.out.println(super.toString());
		System.out.println("So phat hanh: " + soPhatHanh);
		System.out.println("Thang phat hanh: " + thangPhatHanh);
	}

}
