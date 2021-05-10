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

import com.mysql.cj.Session;
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

	private void Listbanbe() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		jdbcUtils.connect();
		String sql = "select userID,UserName from facebookphake.user"
				+ "where userId IN (SELECT UserID2 FROM facebookphake.relationship WHERE UserID1 = ? and `status`='1' "
				+ "union SELECT UserID1 FROM facebookphake.relationship WHERE UserID2 = ? and `status`='1' )";

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("userID: "));
			System.out.println(resultSet.getString("userName: "));
		}
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
		// TODO Auto-generated method stub

	}

	public void dangKi() {
		// TODO Auto-generated method stub

	}

}
