package com.vti.backend.presentation;

import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

public class UserController {
	private static IUserService userService;
	
	public UserController() {
		super();
		userService = new UserService();
	}


	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return userService.login(email,password);
	}

	public List<User> getListUsers(int id) {
		// TODO Auto-generated method stub
		return userService.getListUsers(id);
	}


	public List<User> getAllManager() {
		// TODO Auto-generated method stub
		return userService.getAllManager();
	}

}
