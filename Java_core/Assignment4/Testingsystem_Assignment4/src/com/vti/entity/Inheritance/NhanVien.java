package com.vti.entity.Inheritance;


public class NhanVien extends CanBo {

	private String congViec;

	public String getCongViec() {
		return congViec;
	}

	public NhanVien(int id, String hoTen, byte tuoi, Gender gioiTinh, String diaChi,String congViec) {
		super(id, hoTen, tuoi,gioiTinh,diaChi);
		this.congViec = congViec;
	}


}
