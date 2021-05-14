package com.vti.fronend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.presentation.UserController;
import com.vti.entity.Manager;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

public class FinalExamProgram {
	private static UserController userController;
	private static JdbcUtils jd;
	private static Scanner sc;
	private static User user;
	private static Manager manager;

	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jd = new JdbcUtils();
		jd.connect();
		sc = new Scanner(System.in);
		userController = new UserController();
		// Q2: Viết function để user nhập vào id project, sau đó in ra tất cả
		// các employee &
		// Manager trong project đó (in ra dạng table)
		// System.out.print("Nhập vào projectID: ");
		// int projectId = sc.nextInt();
		// List<User> users = UserController.getListUserByProID(projectId);
		// for (User user : users) {
		// System.out.println(user.toString());
		// }
		// Q2: Viết function để user nhập vào id project, sau đó in ra tất cả
		// các employee &
		// Manager trong project đó (in ra dạng table)
		
		getListUserByProID();
		
		// Q3:Viết function để user có thể lấy ra tất cả Manager của các project
		// (in ra dạng
		// table)
		
		getAllManager();
		
		// Q4Viết chức năng login, User sẽ nhập Email và Password trên giao diện
		// login
		// Chương trình phải kiểm tra được các hợp lệ của các thuộc tính
		
		mainMenu();
	}

	private static void getAllManager() {
		System.out.println(
				"---------------------DANH SÁCH CÁC MANAGER CỦA TỪNG PROJECT ĐANG ĐƯỢC THỰC HIỆN---------------------------");
		List<User> users = userController.getAllManager();
		System.out.printf("%-10s %-20s %-20s %-20s\n", "USER_ID", "PROJECT_ID", "FULL_NAME", "Email");
		for (User user : users) {
			System.out.printf("%-10s %-20s %-20s %-20s\n", user.getId(), user.getProjectID(), user.getFullName(),
					user.getEmail());
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------");
	}

	private static void getListUserByProID() {
		System.out.print("Hãy nhập vào ID của proJect muốn tra thông tin: ");
		int projectId = sc.nextInt();
		List<User> users = UserController.getListUserByProID(projectId);
		System.out.println(
				"----------------- DANH SÁCH USER CỦA PROJECT CÓ ID = |" + projectId + "| ------------------------");
		System.out.printf("%-10s %-20s %-20s\n", "ProjectId", "UserID", "FullName");
		for (User user : users) {
			// System.out.println(user.toString());
			System.out.printf("%-10s %-20s %-20s\n", projectId, user.getId(), user.getFullName());
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------");
	}

	private static void mainMenu() {
		showMainMenu();
		int choose = sc.nextInt();
		System.out.println();
		if (choose == 1) {
			System.out.println("---------------WeLLCome--------------------------.");
			System.out.println("### Đăng nhập                                      .");
			System.out.println("--------------------------------------------------.");
			System.out.print("Nhap vao Email cua ban: ");
			String email = ScannerUtils.inputEmail("email không hợp lệ, mời bạn nhập lại(VD Abc@vti.com.vn)");
			System.out.print("Nhap vao passWord cua ban: ");
			String passWord = ScannerUtils
					.inputPassword("password phải có số kí tự >=6 và <=12,Chứa ít nhất 1 kí tự viết hoa và một số(VD: Abcde1234) ");
			user = dangNhap(email, passWord);
			System.out.println("Chào mừng " + user.getFullName() + "!");
			EndScreen();
		}else{
			System.out.println("bye bye");
		}
	}

	private static User dangNhap(String email, String passWord) {
		return userController.dangNhap(email, passWord);
	}

	private static void showMainMenu() {
		System.out.println(".---------------WELLCOME---------------------.");
		System.out.println(". 1. Đăng nhập                                     .");
		System.out.println(". 2. Thoát                                         .");
		System.out.println(".--------------------------------------------------.");
		System.out.println(". Hãy chọn chức năng : ");
	}
	private static void EndScreen() {
		System.out.println("=================================");
		System.out.println();
		System.out.println("Ấn 'Enter' để tiếp tục.");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}