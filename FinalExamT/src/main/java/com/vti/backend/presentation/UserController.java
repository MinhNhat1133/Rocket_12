package com.vti.backend.presentation;

import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class UserController {
	private static IUserService userService;
	
	public UserController() {
		super();
		userService = new UserService();
	}


	public User dangNhap(String email, String passWord) {
		// TODO Auto-generated method stub
		return userService.dangNhap(email,passWord);
	}



	public static List<User> getListUserByProID(int projectId) {
		// TODO Auto-generated method stub
	 return userService.getListUserByProID(projectId);
	}


	public List<User> getAllManager() {
		// TODO Auto-generated method stub
		return userService.getAllmanager();
	}

}
