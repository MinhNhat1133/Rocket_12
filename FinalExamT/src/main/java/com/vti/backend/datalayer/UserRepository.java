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

import com.vti.entity.Project;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

public class UserRepository implements IUserRepository {
	private static JdbcUtils jd;
	private static Connection connection;

	public User login(String email, String password)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		User user = null;
		jd.connect();
		connection = jd.connect();
		String sql = "SELECT * FROM `user` WHERE `email` = ? AND `password` = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// set parameter
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			int userId = resultSet.getInt("id");
			String fullName = resultSet.getNString("fullName");
			User user1 = new User(userId, fullName, email);
			return user1;
		} else {
			System.out.println("sai email hoac mat khau moi ban nhap lai");
		}
		jd.disconnect();
		return user;
	}

	public List<User> getListUsers(int id)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		jd.connect();
		Connection connection = jd.connect();
		List<User> users = new ArrayList<User>();
		String sql = "SELECT 	pau.projectId, u.`fullName`, pau.`Role`	" + "FROM	`ProjectAndUser` pau"
				+ "JOIN	`User` u	ON u.id = pau.userId" + "WHERE	pau.projectId = @project_id";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			int userId = result.getInt("UserID");
			String fullName = result.getNString("FullName");
			// Role role = Role.valueOf(result.getString("Role").toUpperCase());
		}
		return users;
	}

	public List<User> getAllManager() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		jd.connect();
		Connection connection = jd.connect();
		List<User> users = new ArrayList<User>();
		String sql = "SELECT 	pau.projectId, u.`fullName`, pau.`Role`	" + "FROM	`ProjectAndUser` pau"
				+ "JOIN	`User` u	ON u.id = pau.userId" + "WHERE	`Role` = 'MANAGER';";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String username = resultSet.getNString(2);
			String email = resultSet.getString(3);
			User user = new User(id, username, email);
			users.add(user);
		}
		return users;
	}

}
