package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Basic {
	private static Properties properties;
	private static Connection connection;

	// Q1
	public static Connection getConnection()
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("resources/resources.properties"));

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		// register the driver class with DriverManager
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect success! ");

		return connection;
	}

	// Q2:Tạo method để tạo position, user sẽ nhập vào name.
	public void showPositions() throws SQLException, ClassNotFoundException, IOException {

		Statement statement = connection.createStatement();

		String sql = "SELECT * FROM `Position`";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("PositionID"));
			System.out.println(resultSet.getString("PositionName"));
		}
	}

	// Q3:Tạo method để tạo position, user sẽ nhập vào name.
	public void createPosition(String name) throws SQLException {
		String sql = "	INSERT INTO `Position` (	PositionName	) "
				+ "	VALUE 				   (		?			)";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, name);

		int effectedRecordAmount = statement.executeUpdate();
		
		
		if (effectedRecordAmount == 1) {
			System.out.println("Them position thanh cong");
		} else {
			System.out.println("Them position that bai ");
		}
	}

	// Q5:Tạo method để delete của position theo id và user sẽ nhập vào id
	public void DeletePosition(int id) throws SQLException {
		String sql = " DELETE FROM `Position` WHERE PositionID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		int effectedRecordAmount = statement.executeUpdate();
		if (effectedRecordAmount > 0) {
			System.out.println("Xoa position thanh cong (so ban ghi bi anh huong" + effectedRecordAmount + " )");
		} else {
			System.out.println("Xoa position that bai (so ban ghi bi anh huong" + effectedRecordAmount + " )");
		}
	}

	// Q4:Tạo method để update tên của position gồm có id = 5 thành "Dev
	public void updatePosition() throws SQLException {
		// Create a statement object
		Statement statement = connection.createStatement();
		// Execute SQL Query with executeUpdate
		String sql = "UPDATE `Position` SET PositionName = 'Dev' WHERE PositionID = 5";
		int effectedRecordAmount = statement.executeUpdate(sql);
		// Handing result set
		if (effectedRecordAmount == 1) {
			System.out.println("Da update thanh cong (so ban ghi bi anh huong" + effectedRecordAmount + " )");
		} else {
			System.out.println("Update that bai (so ban ghi bi anh huong" + effectedRecordAmount + " )");
		}
	}

	public void closeConnection() throws SQLException {
		// Close connection
		connection.close();
	}

}
