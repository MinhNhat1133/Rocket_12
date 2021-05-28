package com.vti.enity.polymorphism;

public class Person {
	private int id ;
	private String ten;
	private Gender gioiTinh;
	private int ngaySinh;
	private String diaChi;
	
	public Person (){
		
	}
	public Person( String ten, Gender gioiTinh, int ngaySinh, String diaChi) {
		this.id = id;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi   = diaChi	;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Gender getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Gender gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(int ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
}
