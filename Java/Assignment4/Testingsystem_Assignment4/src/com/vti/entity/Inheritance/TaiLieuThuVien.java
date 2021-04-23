package com.vti.entity.Inheritance;

public class TaiLieuThuVien {
 private int maTaiLieu ;
 private String tenNhaXuatBan;
 private int soBanPhatHanh;
 
 public TaiLieuThuVien (){
	 
 }
 
public TaiLieuThuVien(int maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh) {
	this.maTaiLieu = maTaiLieu;
	this.tenNhaXuatBan = tenNhaXuatBan;
	this.soBanPhatHanh = soBanPhatHanh;
}


public int getmaTaiLieu() {
	return maTaiLieu;
}

public void setmaTaiLieu(int maTaiLieu) {
	this.maTaiLieu = maTaiLieu;
}

public int getSoBanPhatHanh() {
	return soBanPhatHanh;
}


public void setSoBanPhatHanh(int soBanPhatHanh) {
	this.soBanPhatHanh = soBanPhatHanh;
}


public String getTenNhaXuatBan() {
	return tenNhaXuatBan;
}

public void setTenNhaXuatBan(String tenNhaXuatBan) {
	this.tenNhaXuatBan = tenNhaXuatBan;
}
@Override
public String toString() {
	return  "MaTaiLieu: "+ maTaiLieu +" "+ "TenNXB: " + tenNhaXuatBan + "  " + "SoBanPhatHanh: " + soBanPhatHanh 
			;
}


}
