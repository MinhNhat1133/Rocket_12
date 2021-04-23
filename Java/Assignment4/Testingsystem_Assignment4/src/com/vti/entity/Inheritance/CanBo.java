package com.vti.entity.Inheritance;

public class CanBo {
	private int id;
	private String hoTen;
	private byte tuoi;
	private Gender gioiTinh;
	private String diaChi;

	public CanBo() {
	}

	public CanBo(int id, String hoTen, byte tuoi, Gender gioiTinh, String diaChi) {
		this.id = id;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Byte getTuoi() {
		return tuoi;
	}

	public void setTuoi(byte tuoi) {
		this.tuoi = tuoi;
	}

	public Gender getGioiTinh() {
		return gioiTinh;
	}

	

	public String getDiachi() {
		return diaChi;
	}

	public void setDiachi(String diachi) {
		this.diaChi = diachi;
	}

	@Override
	public String toString() {
		return  "Id: "+ id +" "+ "hoten: " + hoTen + " , " + "tuoi: " + tuoi + " , " + "GioiTinh:" + gioiTinh +" "+ ", DiaChi: " + diaChi
				;
	}
}