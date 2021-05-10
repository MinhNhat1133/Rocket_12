package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.presentationlayer.UserController;
import com.vti.ultils.JdbcUtils;
import com.vti.ultils.ScannerUtils;

public class Program {
	private static UserController userController;

	public static void main(String[] args)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		userController = new UserController();
		JdbcUtils jd = new JdbcUtils();
		jd.connect();

		int choose;
		do {
			System.out.println("===============================================");
			System.out.println("===============================================");
			System.out.println("=====| WELLCOME TO FACEBOOK_PHAKE |============");
			System.out.println("-----------------------------------------------");
			System.out.println("==========||1. Đăng Nhập .....................");
			System.out.println("==========||2. Đăng kí ........................");
			System.out.println("===============================================");
			System.out.println("=======||=========");
			choose = ScannerUtils.inputInt("Vui lòng nhập một số trên đây để chọn chức năng ");
			switch (choose) {
			case 1:
				userController.dangNhap();
				break;
			case 2:
				userController.taoTaiKhoan();
				break;
			default:
				System.out.println("Nhập sai, vui lòng nhập lại !");
				break;
			}

		} while (choose != 0);
	}

}