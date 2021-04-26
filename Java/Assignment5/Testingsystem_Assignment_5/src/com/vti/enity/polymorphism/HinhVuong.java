package com.vti.enity.polymorphism;

public class HinhVuong extends HinhChuNhat {
	public float tinhChuViHinhVuong(float a) {
		return super.tinhChuVi(a, a);
	}

	public float tinhDienTichHinhVuong(float a) {
		return this.tinhDienTich(a, a);
	}
}
