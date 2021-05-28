package com.vti.entity.Inheritance;


public class KySu extends CanBo {

	private String nganhDaoTao;

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public KySu(int id, String hoTen, byte tuoi, Gender gioiTinh, String diaChi,String nganhDaoTao) {
		super(id, hoTen, tuoi,gioiTinh,diaChi);
		this.nganhDaoTao = nganhDaoTao;
	}

}
