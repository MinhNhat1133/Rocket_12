package com.vti.entity.Inheritance;

public class CanBo {

	private String hoTen;
	private byte tuoi;
	private Gender gioiTinh;
	private String diaChi;

	public CanBo() {
	}

	public String getHoTen() {
		return hoTen;
	}

	public Byte getTuoi() {
		return tuoi;
	}

	public Gender getGioiTinh() {
		return gioiTinh;
	}

	private void setGioiTinh(int gioiTinh) {
		if (gioiTinh == 0) {
			this.gioiTinh = Gender.valueOf("MALE");
		} else if (gioiTinh == 1) {
			this.gioiTinh = Gender.valueOf("FEMALE");
		} else {
			this.gioiTinh = Gender.valueOf("UNKNOWN");
		}
	}

	public String getDiachi() {
		return diaChi;
	}
	public void setDiachi(String diachi) {
		this.diaChi = diachi;
	}

	
	@Override
	public String toString() {
		return "CanBo{" + "hoten='" + hoTen + '\'' + ", tuoi=" + tuoi + ", gt=" + gioiTinh + ", diachi='" + diaChi
				+ '\'' + '}';
	}
}