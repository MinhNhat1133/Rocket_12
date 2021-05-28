package com.vti.entity.Inheritance;

import java.util.ArrayList;

public class QuanLyCanBo {
	// mang nay chua cac ds cac can bo va Truyen vao doi tuong cha va no se chua
	// ca cac doi tuong con
	private ArrayList<CanBo> dscb;

	public QuanLyCanBo() {
		dscb = new ArrayList<CanBo>();
	}

	// khong can gia tri nao tra ve nen de "Void"
	//
	public void ThemMoiCanBo(int id, String hoTen, byte tuoi, Gender gioiTinh, String diaChi, short type,
			String thuocTinhThem) {
		if (type == 1) {
			// Cong nhan co thuoc tinh (short Bac) nen phai ep kieu du kieu tu
			// String sang short
			CongNhan congNhan1 = new CongNhan(id, hoTen, tuoi, gioiTinh, diaChi, Short.valueOf(thuocTinhThem));
			dscb.add(congNhan1);
		} else if (type == 2) {
			KySu kysu1 = new KySu(id, hoTen, tuoi, gioiTinh, diaChi, thuocTinhThem);
			dscb.add(kysu1);
		} else if (type == 3) {
			NhanVien nhanvien1 = new NhanVien(id, hoTen, tuoi, gioiTinh, diaChi, thuocTinhThem);
			dscb.add(nhanvien1);
		} else {
			System.out.println("do nothing");
		}
	}

	public void HienThiThongTin() {
		for (CanBo canBo : dscb) {
			// to String tro sang toString o class CanBo
			System.out.println(canBo.toString());
		}
	}

	public void TimKiemTheoTen(String hoTen) {
		for (CanBo canBo : dscb) {
			if (hoTen.equals(canBo.getHoTen())) {
				System.out.println(canBo.toString());
			}
		}
	}

	public void XoaCanBoTheoTen(String hoTen) {
		for (int i = 0; i < dscb.size(); i++) {
			if (hoTen.equals(dscb.get(i).getHoTen())) {
				dscb.remove(i);
				i--;
			}
		}
	}
}
