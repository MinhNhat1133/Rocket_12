package com.vti.entity.Inheritance;


public class CongNhan extends CanBo {

	private short bac;

	public CongNhan(int id, String hoTen, byte tuoi, Gender gioiTinh, String diaChi,short bac) {
		super( id, hoTen, tuoi,gioiTinh,diaChi);
		this.bac = bac;
	}
	public short getBac() {
		return bac;
	}
	public void setBac(short bac) {
		this.bac = bac;
	}

}
