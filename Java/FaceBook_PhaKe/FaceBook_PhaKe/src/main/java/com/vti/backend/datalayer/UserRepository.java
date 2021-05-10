package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.vti.entity.User;
import com.vti.ultils.JdbcUtils;
import com.vti.ultils.ScannerUtils;

public class UserRepository implements IUserRepository {
	private JdbcUtils jdbcUtils;
	private Connection connection;

	public UserRepository() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		super();
		jdbcUtils = new JdbcUtils();
		connection = jdbcUtils.connect();
	}

	public void dangNhap() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		String userName;
		String password;
		do {
			System.out.println("Hay Nhap UserName: ");
			userName = ScannerUtils.inputString("Ten khong hop le Hoac ta ton tai");
			System.out.println("Hay Nhap password: ");
			password = ScannerUtils.inputString("Mat Khau bi sai hoac khong hop le");
			if (CheckNameAndPassForLognIn(userName, password) == false) {
				System.out.println("Sai ten hoac mat khau,vui long nhap lai");
			} else {
				System.out.println("Dang nhap thanh cong");
				loadMenuOfUser();
			}

		} while (true);

	}

	public boolean CheckNameAndPassForLognIn(String username, String password)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		Connection connection = jdbcUtils.connect();
		String sql = "SELECT * FROM User WHERE UserName = ? and password = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	public void dangKi() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		String userName;
		String password;
		String email;
		int age;
		do {
			System.out.println("hay tao userName: ");
			userName = ScannerUtils.inputString("Ten khong hop le Hoac ta ton tai");
			if (CheckNameForSignUp(userName) != true) {
				System.out.println("NHap email cua ban: ");
				email = ScannerUtils.inputString("email khong hop le");
				System.out.println("Hay Nhap vao tuoi cua ban");
				age = ScannerUtils.inputInt("tuoi khong hop le");
				System.out.println("Hay Nhap password ban muon tao: ");
				password = ScannerUtils.inputString("password ko hop le");
				Connection connection = jdbcUtils.connect();
				String sql = "	INSERT INTO user (UserName,email,Age,password)" + "	VALUE ( ?,?,?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, email);
				preparedStatement.setInt(3, age);
				preparedStatement.setString(4, password);
				preparedStatement.executeUpdate();
				System.out.println("Da dang ki than cong");
			} else {
				System.out.println("username_" + userName + "_da duoc dung vui long nhap userName khac");
			}
		} while (false);
	}

	private boolean CheckNameForSignUp(String userName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Connection connection = jdbcUtils.connect();
		String sql = "SELECT * FROM User WHERE UserName = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userName);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	private void loadMenuOfUser() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		int choose;
		do {
			System.out.println("--------------- Chọn Tác vụ bạn muốn thực hiện ------------------------------");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("==========||1.  Hien Thi Danh sach ban be ...................................");
			System.out.println("==========||2.  Hien thi danh sach 10 nguoi nhan tin gan nhat ...............");
			System.out.println("==========||3.	Hien thi Tin nhan cua 1 nguoi ban  ..........................");
			System.out.println("==========||4.  Nhan tin cho 1 nguoi ban bat ki .............................");
			System.out.println("==========||5.  Ket ban voi 1 nguoi .........................................");
			System.out.println("==========||6.  Dong y ket ban ..............................................");
			System.out.println("==========||7.  Dang xuat ...................................................");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("=============================================================================");
			choose = ScannerUtils.inputInt("Vui long nhap 1 so tren day ");
			switch (choose) {
			case 1:
				Listbanbe();
				break;
			case 2:
				Listbanbenhantin();
				break;
			case 3:
				HienTinNhan();
				break;
			case 4:
				NhanTin();
				break;
			case 5:
				GuiLoiMoiKetBan();
				break;
			case 6:
				ChapNhanMoiKetBan();
				break;
			case 7:
				dangxuat();
			default:
				System.out.println("Nhập sai, vui lòng nhập lại !");
				break;
			}

		} while (choose != 0);

	}

	private List<User> Listbanbe() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		jdbcUtils.connect();
		List<User> users = new ArrayList<User>();
		String sql = "select userID,UserName from facebookphake.user"
				+ "where userId IN (SELECT UserID2 FROM facebookphake.relationship WHERE UserID1 = ? and `status`='1' "
				+ "union SELECT UserID1 FROM facebookphake.relationship WHERE UserID2 = ? and `status`='1' )";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("userID: "));
			System.out.println(resultSet.getString("userName: "));
		}
		return users;
	}

	private void Listbanbenhantin() {
		// TODO Auto-generated method stub

	}

	private void HienTinNhan() {
		// TODO Auto-generated method stub

	}

	private void NhanTin() {
		// TODO Auto-generated method stub

	}

	private void GuiLoiMoiKetBan() {
		// TODO Auto-generated method stub

	}

	private void ChapNhanMoiKetBan() {
		// TODO Auto-generated method stub

	}

	private void dangxuat() {
		;

	}

}
