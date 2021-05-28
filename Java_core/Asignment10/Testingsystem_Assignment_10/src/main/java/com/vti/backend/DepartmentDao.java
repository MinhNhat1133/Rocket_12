package com.vti.backend;

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

import org.omg.Messaging.SyncScopeHelper;

import com.vti.entity.Department;
import com.vti.utils.JDBCUtils;
import com.vti.utils.MessageProperties;

public class DepartmentDao {
	private static JDBCUtils jdbcUtils;
	private static Connection connection;
	List<Department> departments = new ArrayList<Department>();

	public DepartmentDao() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		super();
		jdbcUtils = new JDBCUtils();
		connection = jdbcUtils.connect();
	}

	// Q1: in ra List department
	private List<Department> getDepartments()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		List<Department> departments = new ArrayList<Department>();
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM Department";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));
			departments.add(department);
		}
		return departments;

	}

	public void getListDep() throws SQLException, IOException, ClassNotFoundException {
		List<Department> departments = new DepartmentDao().getDepartments();

		for (Department department : departments) {
			System.out.println(department);
		}
	}

	// Q2_Q3:tra ra thong tin cua department co id ma nguoi dung nhap vao:
	public Department showDepById(int id)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Connection connection = jdbcUtils.connect();
		Department department = new Department();
		// Create a statement object
		String sql = "SELECT * FROM Department WHERE DepartmentId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			System.out.println(("DepartmentID: " + resultSet.getInt("DepartmentId") + " //" + " DepartmentName: "
					+ resultSet.getString("DepartmentName")));
			return department;

		} else {
			System.out.println("Cannot find department which has id = " + id);
		}
		jdbcUtils.disconnect();
		return department;
	}

	// Q4:cho người dùng nhập vào và kiểm tra xem chuỗi đó có tồn tại hay chưa
	private boolean xetTenTonTaiChua(String name) throws SQLException, IOException, ClassNotFoundException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM Department WHERE DepartmentName = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

	public void xetTenTonTaiChua() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Nhap ten Department muon tra : ");
		String name = sc1.nextLine();
		boolean result = new DepartmentDao().xetTenTonTaiChua(name);
		System.out.println("Result: " + result);
		jdbcUtils.disconnect();
	}

	// Q5:Tao dep
	public void createDep(String name) throws ClassNotFoundException, SQLException, IOException {
		// check name exist
		if (xetTenTonTaiChua(name) != true) {
			Connection connection = jdbcUtils.connect();
			String sql = "	INSERT INTO Department (DepartmentName)" + "	VALUE (   ?	)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			System.out.println("da tao department thanh cong");
		} else {
			System.out.println("Department co ten " + "||" + name + "||" + " da ton tai vui long nhap mot ten khac");
		}
	}

	// Q6: Update
	public boolean xetIdCoTonTai(int id) throws SQLException, IOException, ClassNotFoundException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM Department WHERE DepartmentID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			return true;

		} else {
			return false;
		}
	}

	public void updateDepartment(int id, String newName) throws SQLException, Exception {

		// check department id exist
		if (xetIdCoTonTai(id) != true) {
			System.out.println("id khong ton tai vui long nhap id khac");
		} else {
			Connection connection = jdbcUtils.connect();
			// Create a statement object
			String sql = "	UPDATE Department SET DepartmentName = ? WHERE DepartmentId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, newName);

			// Step 4: execute query
			preparedStatement.executeUpdate();
			System.out.println("Update thanh cong");
			jdbcUtils.disconnect();
		}
		// public void deleteDepartment(int id) throws Exception {
		//
		// // check department id exist
		// if (!isDepartmentIdExists(id)) {
		// throw new Exception(
		// messagePoperties.getProperty("department.getDepartmentByID.cannotFindDepartmentById")
		// + id);
		// }
		//
		// // if department id not exist delete
		//
		// // get connection
		// Connection connection = jdbcUtils.connect();
		//
		// // Create a statement object
		// String sql = "DELETE FROM Department WHERE DepartmentID = ?";
		// PreparedStatement preparedStatement =
		// connection.prepareStatement(sql);
		//
		// // set parameter
		// preparedStatement.setInt(1, id);
		//
		// // Step 4: execute query
		// preparedStatement.executeUpdate();
		//
		// // disconnect
		// jdbcUtils.disconnect();
		// }
		//
		// }

	}

	public void deleteDep(int id3) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		if (xetIdCoTonTai(id3) == true) {
			// get connection
			Connection connection = jdbcUtils.connect();

			// Create a statement object
			String sql = "DELETE FROM Department WHERE DepartmentID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id3);

			// Step 4: execute query
			preparedStatement.executeUpdate();
			System.out.println("delete thanh cong");

		} else {
			System.out.println("department co id la |" + id3 + "| ko ton tai, vui long nhap mot id khac");

		}
	}
}