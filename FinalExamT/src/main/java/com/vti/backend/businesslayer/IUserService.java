package com.vti.backend.businesslayer;

import java.util.List;

import com.vti.entity.Manager;
import com.vti.entity.User;

public interface IUserService {

	User dangNhap(String email, String passWord);


	List<User> getListUserByProID(int projectId);


	List<User> getAllmanager();

}
