package com.vti.backend.presentationlayer;

import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.Message;
import com.vti.entity.User;

public class UserController {
	private static IUserService userService;

	public UserController() {
		super();
		userService = new UserService();
	}

	public void taoTaiKhoan(String userName, String email, int age, String passWord) {
		userService.taoTaiKhoan(userName,email,age,passWord);

	}

	public static List<User> danhSachbanbe(int id) {
		return userService.danhsachbanbe(id);
	}

	public User dangnhap(String userName, String passWord) {
		return userService.dangnhap(userName, passWord);
	}

	public List<User> bbNhanTinGanDayNhat(int id) {
		// TODO Auto-generated method stub
		return userService.dsbbNhanTinGanday(id);
	}

	public List<Message> showTinnhan(int id, int friendID) {
		return userService.showTinNhan(id,friendID);
	}

	public void nhanTin(int id, int friendID, String message) {
		userService.nhanTin(id,friendID,message);
		
	}


	public void guiLoiMoikb(int id, int addFriendID) {
		userService.guiLoiMoikb(id,addFriendID);
		
	}

	public List<User> LoiMoikb(int id) {
		// TODO Auto-generated method stub
		return userService.LoiMoikb(id);
	}

	public void chapNhanLoiMoikb(int id, int userSendID) {
		userService.chapNhanLoiMoikb(id,userSendID);
		
	}

}
