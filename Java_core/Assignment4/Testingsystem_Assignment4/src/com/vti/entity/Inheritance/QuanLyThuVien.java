package com.vti.entity.Inheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyThuVien {
	private ArrayList<TaiLieuThuVien> dstl;

	public QuanLyThuVien() {
		dstl = new ArrayList<TaiLieuThuVien>();
	}

	public void ThemMoiTaiLieuThuVien(int maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, byte type,
			String thuocTinhThem1, String thuocTinhThem2) {
		if (type == 1) {
			// Cong nhan co thuoc tinh (short Bac) nen phai ep kieu du kieu tu
			// String sang short
			Sach sach1 = new Sach(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, thuocTinhThem1,
					Short.valueOf(thuocTinhThem2));
			dstl.add(sach1);
		} else if (type == 2) {
			TapChi tapchi1 = new TapChi(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, Short.valueOf(thuocTinhThem1),
					Byte.valueOf(thuocTinhThem2));
			dstl.add(tapchi1);
		} else if (type == 3) {
			Bao bao1 = new Bao(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, Byte.valueOf(thuocTinhThem1));
			dstl.add(bao1);
		} else {
			System.out.println("do nothing");
		}
	}

	public void HienThiThongTinTaiLieuThuVien() {
		for (TaiLieuThuVien tltv : dstl) {
			// to String tro sang toString o class CanBo
			System.out.println(tltv.toString());
		}
	}

	public void XoaTaiLieuTheoMTL(int maTaiLieu) {

		for (int i = 0; i < dstl.size(); i++) {
			if (maTaiLieu == (dstl.get(i).getmaTaiLieu())) {
				dstl.remove(i);
				;
			}
		}

	}

	public void TimTaiLieuTheoTungLoai() {
		Scanner scanner = new Scanner(System.in);

		int choose;
		System.out.println("Nhap loai ban muon tim kiem: (1:Sach || 2: Tap chi || 3: Bao)");
		choose = scanner.nextByte();

		switch (choose) {
		case 1:
			for (TaiLieuThuVien taiLieu : dstl) {
				if (taiLieu instanceof Sach) {
					((Sach) taiLieu).getInfor();
				}
			}
			break;
		case 2:
			for (TaiLieuThuVien taiLieu : dstl) {
				if (taiLieu instanceof TapChi) {
					((TapChi) taiLieu).getInfor();
				}
			}
			break;
		case 3:
			for (TaiLieuThuVien taiLieu : dstl) {
				if (taiLieu instanceof Bao) {
					((Bao) taiLieu).getInfor();
				}
			}
			break;
		default:
			System.out.println("Nhap sai !");
			break;
		}
	}

}
