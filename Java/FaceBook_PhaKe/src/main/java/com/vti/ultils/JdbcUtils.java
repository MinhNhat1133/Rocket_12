package com.vti.ultils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	static Properties properties;
	static Connection connection;

	// Question 2: Tạo method để get Connect tới database.
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public Connection connect() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		if (connection != null && !connection.isClosed()) {
			return connection;
		}
// Step 2: Get a connection to database
		// load file properties file
		properties = new Properties();
		properties.load(new FileInputStream("resources\\resources.properties"));
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");

		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect success! ");

		return connection;
	}


}
