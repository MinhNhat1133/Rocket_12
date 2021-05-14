package com.vti.backend.businesslayer;

import java.util.List;

import com.vti.entity.User;

public interface IUserService {
	User login(String email, String password);

	List<User> getListUsers(int id);

	List<User> getAllManager();

}
