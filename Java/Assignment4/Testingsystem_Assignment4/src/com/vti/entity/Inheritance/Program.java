package com.vti.entity.Inheritance;

public class Program {
	public static void main(String[] args) {
//		QuanLyCanBo qlcb = new QuanLyCanBo();
//		qlcb.ThemMoiCanBo(1, "Nguyen Van A", (byte) 20, Gender.MALE, "Ha Noi", (short) 1, "8");
//		qlcb.ThemMoiCanBo(2, "Hoang"	   , (byte) 23, Gender.MALE, "Ha Noi", (short) 2, "abc7");
//		qlcb.ThemMoiCanBo(3, "Nguyen Van B", (byte) 25, Gender.MALE, "TP HCM", (short) 2, "abc");
//		qlcb.ThemMoiCanBo(4, "Nguyen Van C", (byte) 30, Gender.MALE, "Ha Noi", (short) 3, "NV1");
//		qlcb.ThemMoiCanBo(5, "Hoang"	   , (byte) 32, Gender.MALE, "Vung Tau", (short) 2, "abc2");
//		qlcb.HienThiThongTin();
////		qlcb.TimKiemTheoTen(" ");
//		qlcb.XoaCanBoTheoTen("Hoang");
//		System.out.println("sau khi xoa doi tuong Hoang: ");
//		qlcb.HienThiThongTin();
//		
		QuanLyThuVien qltv = new QuanLyThuVien();
		qltv.ThemMoiTaiLieuThuVien(1,"NXB1", 23,(byte) 1, "ToHuu", "200");
		qltv.ThemMoiTaiLieuThuVien(2,"NXB2", 20,(byte) 2, "120"	 , "12");
		qltv.ThemMoiTaiLieuThuVien(3,"NXB3", 26,(byte) 3, "25"	, null);
		qltv.HienThiThongTinTaiLieuThuVien();
		qltv.XoaTaiLieuTheoMTL(2);
//		System.out.println("sau khi xoa: ");
//		qltv.HienThiThongTinTaiLieuThuVien();
		qltv.TimTaiLieuTheoTungLoai();
	}
}
