package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Manager;
import com.vti.entity.User;

public interface IUserRepository {

	User dangNhap(String email, String passWord) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	List<User> getListUserByProID(int projectId) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	List<User> getAllManager() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

}
