package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;

public class UserController {
	private IUserService userservice;
	
	
	public UserController() {
		super();
		userservice = new UserService();
	}

	public void dangNhap() {
		userservice.dangnhap();
	}

	public void taoTaiKhoan() {
		userservice.taoTaiKhoan();
	}

}
