package com.vti.backend.businesslayer;

import java.util.List;

import com.vti.entity.Message;
import com.vti.entity.User;

public interface IUserService {

	List<User> danhsachbanbe(int id);

	User dangnhap(String userName, String passWord);

	void taoTaiKhoan(String userName, String email, int age, String passWord);

	List<User> dsbbNhanTinGanday(int id);

	List<Message> showTinNhan(int id, int friendID);

	void nhanTin(int id, int friendID, String message);

	void guiLoiMoikb(int id, int addFriendID);

	List<User> LoiMoikb(int id);

	void chapNhanLoiMoikb(int id, int userSendID);

}
