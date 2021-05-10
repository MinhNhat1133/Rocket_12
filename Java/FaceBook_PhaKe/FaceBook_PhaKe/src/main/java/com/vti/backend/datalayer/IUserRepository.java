package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public interface IUserRepository {

	void dangNhap() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	void dangKi() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

}
