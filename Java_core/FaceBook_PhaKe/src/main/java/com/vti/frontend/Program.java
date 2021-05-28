package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Message;
import com.vti.entity.User;
import com.vti.ultils.JdbcUtils;

public class Program {
	private static UserController userController;
	private static JdbcUtils jd;
	private static boolean isLogin;
	private static Scanner sc;
	private static User user;

	public static void main(String[] args)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		jd = new JdbcUtils();
		jd.connect();
		sc = new Scanner(System.in);
		userController = new UserController();
		isLogin = false;
		mainMenu();

	}

	private static void mainMenu() {
		while (true) {
			if (!isLogin) {
				showMainMenu();
				int choose = sc.nextInt();
				System.out.println();
				if (choose == 1) {
					System.out.println("---------------FaceBook PhaKe---------------------.");
					System.out.println("### Đăng nhập                                      .");
					System.out.println("--------------------------------------------------.");
					System.out.print("Nhap vao userName cua ban: ");
					String userName = sc.next();
					System.out.print("Nhap vao passWord cua ban: ");
					String passWord = sc.next();
					user = dangNhap(userName, passWord);
					if (user != null)
						isLogin = true;
				}

				if (choose == 2) {
					System.out.println("---------------FaceBook PhaKe---------------------.");
					System.out.println("### Đăng Ky                                     .");
					System.out.println("--------------------------------------------------.");
					System.out.println("Nhập UserName muốn tạo : ");
					String userName = sc.next();
					System.out.println("Nhap email ban muon tao: ");
					String email = sc.next();
					System.out.println("Nhap vao tuoi cua ban: ");
					int age = sc.nextInt();
					System.out.print("Nhập passWord muốn tạo : ");
					String passWord = sc.next();
					taoTaiKhoan(userName, email, age, passWord);

				}

				if (choose == 0) {
					System.out.println("Bye bye.");
					break;
				}
			} else {
				showUsermenu();
				int choose = sc.nextInt();
				System.out.println();
				switch (choose) {
				case 1:
					hienthidsbanbe(danhSachbanbe(user.getId()));
					break;
				case 2:
					hienthidsbbNhanTinGanDayNhat(bbNhanTinGanDayNhat(user.getId()));
					break;
				case 3:
					System.out.print("Hãy nhập id của một người bạn để xem tin nhắn của bạn với người đó: ");
					int friendID = sc.nextInt();
					showTinnhan(user.getId(), friendID);
					break;
				case 4:
					System.out.print("Nhap id cua nguoi ban muon gui tin nhan: ");
					int friendID1 = sc.nextInt();
					System.out.println("Nhap noi dung tin nhan ");
					String message = sc.nextLine();
					nhanTin(user.getId(),friendID1,message);
					break;
				case 5:
					System.out.println("Nhap id cua nguoi ban muon gui loi moi ket ban: ");
					int addFriendID = sc.nextInt();
					guiLoiMoikb(user.getId(),addFriendID);
					break;
				case 6:
					HienthidsYeuCaukb(LoiMoikb(user.getId()));
					System.out.println("Nhập ID của user bạn muốn chấp nhận lời mời kb");
					int userSendID = sc.nextInt();
					chapNhanLoiMoikb(user.getId(),userSendID);
					break;
				case 7:
					System.out.println("ket thuc chuong trinh ");
					isLogin = false;
					break;

				}

			}

		}

	}

	private static void chapNhanLoiMoikb(int id, int userSendID) {
		userController.chapNhanLoiMoikb(id,userSendID);
		
	}

	private static List<User> LoiMoikb(int id) {
		// TODO Auto-generated method stub
		return userController.LoiMoikb(id);
	}

	private static void HienthidsYeuCaukb(List<User>LoiMoikb) {
		System.out.println("Danh sách lời mời kết bạn được gửi tới bạn ");
		for (User user : LoiMoikb) {
			System.out.println(user.toStringIdandName());
			
		}
		EndScreen();
		
	}

	private static void hienthidsbanbe(List<User> danhSachbanbe) {
		System.out.println("Danh sach ban be hien tai cua ban");
		for (User user : danhSachbanbe) {
			System.out.println(user.toStringIdandName());
		}
		EndScreen();
	}

	private static void hienthidsbbNhanTinGanDayNhat(List<User> bbNhanTinGanDayNhat) {
		System.out.println("Danh sach ban be nhan tin voi ban gan day nhat");
		for (User user : bbNhanTinGanDayNhat) {
			System.out.println(user.toStringIdandName());
		}
		EndScreen();
	}


	private static void guiLoiMoikb(int id, int addFriendID) {
		userController.guiLoiMoikb(id,addFriendID);
		EndScreen();

	}

	private static void nhanTin(int id, int friendID, String message) {
		userController.nhanTin(id,friendID,message);
		EndScreen();

	}

	private static void showTinnhan(int id, int friendID) {
		// TODO Auto-generated method stub
		List<Message> messages = userController.showTinnhan(id, friendID);
		if (messages != null) {
			for (Message message : messages) {
				System.out.println(message.toString_IdContentDate());
			}
		} else {
			System.out.println("Thư mục tin nhắn rỗng");
		}
		EndScreen();

	}

	private static List<User> bbNhanTinGanDayNhat(int id) {
		return userController.bbNhanTinGanDayNhat(id);

	}

	private static List<User> danhSachbanbe(int id) {
		return UserController.danhSachbanbe(id);

	}

	private static User dangNhap(String userName, String passWord) {
		return userController.dangnhap(userName, passWord);
	}

	private static void taoTaiKhoan(String userName, String email, int age, String passWord) {
		userController.taoTaiKhoan(userName, email, age, passWord);

	}

	private static void showUsermenu() {
		System.out.println(".------|| WellCome user " + user.getName() + " ||------.");
		System.out.println(". 1. Hiện danh sách bạn bè                         	 .");
		System.out.println(". 2. Danh sách bạn bè nhắn tin với bạn gần đây nhất  .");
		System.out.println(". 3. Hiển thị tin nhắn với một người bạn(bằng ID)    .");
		System.out.println(". 4. Nhắn tin                                        .");
		System.out.println(". 5. Kết bạn	                                     .");
		System.out.println(". 6. danh sách lời mời kết bạn                       .");
		System.out.println(". 7. Thoát                                           .");
		System.out.println(".--------------------------------------------------.");

	}

	private static void showMainMenu() {
		System.out.println(".---------------FaceBook PhaKe---------------------.");
		System.out.println(". 1. Đăng nhập                                     .");
		System.out.println(". 2. Tạo tài khoản                                 .");
		System.out.println(". 0. Thoát                                         .");
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
