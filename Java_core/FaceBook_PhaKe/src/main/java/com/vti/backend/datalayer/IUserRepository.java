package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Message;
import com.vti.entity.User;

public interface IUserRepository {

	List<User> danhsachbanbe(int id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	void taoTaiKhoan(String userName, String email, int age, String passWord) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	User dangNhap(String userName, String passWord) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	List<User> dsbbNhanTinGanday(int id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	List<Message> showTinnhan(int id, int friendID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	void nhanTin(int id, int friendID, String message) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	void guiLoiMoikb(int id, int addFriendID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	List<User> LoiMoikb(int id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	void chapNhanLoiMoikb(int id, int userSendID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;



}
