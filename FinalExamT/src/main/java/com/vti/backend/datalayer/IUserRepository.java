package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Manager;
import com.vti.entity.User;

public interface IUserRepository {


	User login(String email, String password) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException, Exception;

	List<User> getListUsers(int id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	List<Manager> getAllManager() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

}
