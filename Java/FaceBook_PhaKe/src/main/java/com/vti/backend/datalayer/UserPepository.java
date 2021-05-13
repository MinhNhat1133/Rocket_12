package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import com.vti.entity.Message;
import com.vti.entity.User;
import com.vti.ultils.JdbcUtils;

public class UserPepository implements IUserRepository {
	private static JdbcUtils jd;
	private static Connection connect;

	public UserPepository() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		super();
		jd = new JdbcUtils();
		connect = jd.connect();
	}

	public User dangNhap(String userName, String passWord)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		User user = null;
		Connection connection = jd.connect();
		String sql = "SELECT * FROM `User` WHERE `userName` = ? AND `passWord` = ?";
		PreparedStatement pre = connection.prepareStatement(sql);
		pre.setString(1, userName);
		pre.setString(2, passWord);
		ResultSet resultSet = pre.executeQuery();
		if (resultSet.next()) {
			user = new User(resultSet.getInt("UserId"), resultSet.getString("Username"), resultSet.getString("email"),
					resultSet.getInt("age"));
			System.out.println("dang nhap thanh cong");
		} else {
			System.out.println("sai userName hoac mat khau moi ban nhap lai");
		}
		jd.disconnect();
		return user;
	}

	public List<User> danhsachbanbe(int id)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<User> users = new ArrayList<User>();
		Connection connection = jd.connect();
		String sql = "SELECT * FROM `user` "
				+ "WHERE userId IN (SELECT UserID2 FROM `relationship` WHERE UserID1 = ? AND `status` ='1' UNION SELECT userID1 FROM `relationship` WHERE userID2 = ? and `status`='1' )";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, id);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			User user = new User(result.getInt("userID"), result.getString("userName"), result.getString("email"),
					result.getInt("age"));
			users.add(user);
		}
		System.out.println("So luong ban be hien tai cua ban la: " + users.size());
		jd.disconnect();
		return users;
	}

	public void taoTaiKhoan(String userName, String email, int age, String passWord)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		if (xetTenTonTaiChua(userName) != true) {
			Connection connection = jd.connect();
			String sql = "	INSERT INTO `User` (userName,email,age,passWord)" + "VALUE ( ?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, passWord);
			preparedStatement.executeUpdate();
			System.out.println("da tao tai thanh cong");
		} else {
			System.out.println("userName co ten " + "||" + userName + "||" + " da ton tai vui long nhap mot ten khac");
		}
	}

	private boolean xetTenTonTaiChua(String userName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Connection connection = jd.connect();
		String sql = "SELECT 1 FROM user WHERE userName = ?";
		PreparedStatement pre = connection.prepareStatement(sql);
		pre.setString(1, userName);
		ResultSet result = pre.executeQuery();
		if (result.next()) {
			return true;
		} else {
			return false;
		}

	}

	public List<User> dsbbNhanTinGanday(int id)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<User> users = new ArrayList<User>();
		Connection connection = jd.connect();
		String sql = "SELECT * FROM `user`WHERE userId IN (SELECT UserSeID as id FROM (SELECT UserSeID,MessageDate FROM message WHERE UserReID = ? "
				+ "UNION SELECT userReID,MessageDate FROM message WHERE userSeID = ? ORDER BY MessageDate DESC )AS a GROUP BY  id)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, id);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			User user = new User(result.getInt("userID"), result.getString("userName"), result.getString("email"),
					result.getInt("age"));
			users.add(user);
		}
		jd.disconnect();
		return users;
	}

	public List<Message> showTinnhan(int id, int friendID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Message> messages = new ArrayList<Message>();
		Connection connection = jd.connect();
		String sql = "SELECT * FROM Message WHERE UserSeID IN (?, ?) AND UserReID IN (?, ?) ORDER BY MessageDate";
		PreparedStatement preStatement = connection.prepareStatement(sql);
		preStatement.setInt(1, id);
		preStatement.setInt(2, friendID);
		preStatement.setInt(3, id);
		preStatement.setInt(4, friendID);
		ResultSet resultSet = preStatement.executeQuery();
		while (resultSet.next()) {
			Message message = new Message(resultSet.getInt("MessageID"), resultSet.getString("Content"),
					resultSet.getDate("messageDate"));
			messages.add(message);
		}
		jd.disconnect();
		return messages;
	}

	public void nhanTin(int id, int friendID, String message)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		if (IsFriend(id, friendID) == true) {
			Connection connection = jd.connect();
			String sql = "INSERT INTO message(userSeID,UserReID,content) VALUES (?,?,?)";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setInt(1, id);
			pre.setInt(2, friendID);
			pre.setString(3, message);
			pre.executeUpdate();
			System.out.println("Đã gửi tin nhắn");
		} else {
			System.out.println("Không thể gửi tin nhắn(Không phải là bạn bè hoặc bạn bị block :D )");
		}
		jd.disconnect();

	}

	private boolean IsFriend(int id, int friendID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		boolean isFr = false;
		jd.connect();
		Connection connection = jd.connect();
		String sql = "SELECT * FROM `Relationship` WHERE userID1 = ? AND userID2 = ? AND status = '1' "
				+ "UNION SELECT * FROM relationship WHERE userID1 =? AND userID2 =? AND `status`='1'";
		PreparedStatement preStatement = connection.prepareStatement(sql);
		preStatement.setInt(1, id);
		preStatement.setInt(2, friendID);
		preStatement.setInt(3, friendID);
		preStatement.setInt(4, id);
		ResultSet resultSet = preStatement.executeQuery();
		isFr = resultSet.next() ? true : false;
		jd.disconnect();
		return isFr;
	}

	public void guiLoiMoikb(int id, int addFriendID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		if (IsFriend(id, addFriendID) != true && IsUserExist(addFriendID) == true) {
			jd.connect();
			Connection connection = jd.connect();
			String sql = "INSERT INTO relationship (userID1,userID2) VALUES ( ? , ?)";
			PreparedStatement prepare = connection.prepareStatement(sql);
			prepare.setInt(1, id);
			prepare.setInt(2, addFriendID);
			prepare.executeUpdate();
			System.out.println("Gui loi moi thanh cong");
		} else {
			System.out.println("cac ban da la ban be hoac nguoi ban muon ket ban khon ton tai ");

		}

	}

	private boolean IsUserExist(int addFriendID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		boolean isUserE = false;
		jd.connect();
		Connection connection = jd.connect();
		String sql = "SELECT * FROM `user` WHERE userID = ?";
		PreparedStatement prepare = connection.prepareStatement(sql);
		prepare.setInt(1, addFriendID);
		ResultSet result = prepare.executeQuery();
		isUserE = result.next() ? true : false;
		jd.disconnect();
		return isUserE;
	}

	public List<User> LoiMoikb(int id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<User> users = new ArrayList<User>();
		jd.connect();
		Connection connection = jd.connect();
		String sql = "SELECT * FROM `user` "
				+ "WHERE userId IN (SELECT UserID1 FROM `relationship` WHERE UserID2 = ? AND `status` ='0') ";
		PreparedStatement prepare = connection.prepareStatement(sql);
		prepare.setInt(1, id);
		ResultSet result = prepare.executeQuery();
		while (result.next()) {
			User user = new User(result.getInt("userID"), result.getString("userName"), result.getString("email"),
					result.getInt("age"));
			users.add(user);
		}
		System.out.println("ban dang co :" + users.size() + " loi moi ket ban ");
		jd.disconnect();
		return users;
	}

	public void chapNhanLoiMoikb(int id, int userSendID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		jd.connect();
		Connection connection = jd.connect();
		String sql = "UPDATE relationship SET `status`='1' WHERE userID1 = ? AND userID2 = ? ";
		PreparedStatement prepare = connection.prepareStatement(sql);
		prepare.setInt(1, userSendID);
		prepare.setInt(2, id);
		prepare.executeUpdate();
		System.out.println("Da chap nhan loi moi ket ban cua user co id la: " + userSendID);
	}

}