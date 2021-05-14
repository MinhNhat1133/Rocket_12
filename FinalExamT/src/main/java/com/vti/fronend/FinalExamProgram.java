package com.vti.fronend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.presentation.UserController;
import com.vti.entity.Project;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

public class FinalExamProgram {
	private static UserController userContronller;
	private static JdbcUtils jd;
	private static Scanner sc;
	private static User user;
	private static Project project;

	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jd = new JdbcUtils();
		sc = new Scanner(System.in);
		user = new User();
		userContronller = new UserController();
		mainmenu();
	}

	private static void mainmenu() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		System.out.println("MỜI BẠN LOGIN");
		System.out.println("Moi ban nhap vao email: ");
		String email = ScannerUtils.inputEmail("email khong hop le");
		System.out.println("nhap vao password");
		String password = ScannerUtils.inputPassword("sai dinh dang mat khau");
		System.out.println("Login successfull!");
		System.out.println("wellcome " + user.getFullName());
		menuUser();

	}

	private static void menuUser() {
		System.out.println("Moi ban nhap chuc nang muon su dung:\n" + "1: In ra danh sach cac user cua project \n"
				+ "2: lấy ra tất cả Manager của các project\n"+ "3: Thoat khoi chuong trinh\n ");
		while (true) {
			System.out.println("Moi ban nhap chuc nang: ");
			int choose = ScannerUtils.inputFunction(1, 5, "Ban chi duoc chon tu 1 --> 5. Mời nhập lại!");

			switch (choose) {
			case 1:
				System.out.println("nhap vao id muon tra ");
				int id = sc.nextInt();
				getListUsers(id);
				break;
			case 2:
				getAllManager();
			case 3:
				System.out.println("bạn đã thoát khỏi chương trình!");
				return;
			}
		}
	}

	private static void getAllManager() {
		List<User> users = userContronller.getAllManager();
		for (User user : users) {
			System.out.println(user.toString());
		}
		
	}

	private static void getListUsers(int id) {
		List<User> users = userContronller.getListUsers(id);
			for (User user : users) {
				System.out.println(user.toString());
			}
		}
	}

