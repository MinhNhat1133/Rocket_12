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

import com.vti.entity.Manager;
import com.vti.entity.ProSkill;
import com.vti.entity.Project;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

public class UserRepository implements IUserRepository {
	private static JdbcUtils jd;
	private static Connection connection;

	public UserRepository() {
		super();
		jd = new JdbcUtils();
	}

	public User dangNhap(String email, String passWord)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		User user = null;
		jd.connect();
		Connection connection = jd.connect();
		String sql = "SELECT * FROM `User` WHERE email = ? AND `password` = ?";
		PreparedStatement preStatement = connection.prepareStatement(sql);
		preStatement.setString(1, email);
		preStatement.setString(2, passWord);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			int id = resultSet.getInt("userId");
			String fullName = resultSet.getString("fullName");
			user = new User(id, fullName, email, passWord);
		}else{
			System.out.println("sai email hoặc password");
		}
		jd.disconnect();
		return user;
	}

	public List<User> getListUserByProID(int projectId)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<User> users = new ArrayList<User>();
		jd.connect();
		Connection connection = jd.connect();
		String sql = "SELECT userID,fullname,ProjectID FROM `user` WHERE projectId = ?";
		PreparedStatement pre = connection.prepareStatement(sql);
		pre.setInt(1, projectId);
		ResultSet resultSet = pre.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getNString(2);
			int projectId1 = resultSet.getInt(3);
			User department = new User(id, name, projectId1);
			users.add(department);
		}
		return users;
	}

	public List<User> getAllManager() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<User> users = new ArrayList<User>();
		jd.connect();
		Connection connection = jd.connect();
		String sql = "SELECT u.userId,p.ProjectID,u.fullName,u.email " + " FROM `User` u " + "JOIN project p "
				+ "ON u.userId = p.ManagerID  " + " WHERE u.userId IN (SELECT ManagerID FROM project)";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			int projectId = resultSet.getInt(2);
			String name = resultSet.getString(3);
			String email = resultSet.getString(4);
			User user = new User(id, projectId, name, email);
			users.add(user);
		}

		jd.disconnect();
		return users;
	}
}
