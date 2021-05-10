package com.vti.entity;

public class User {
	private int id;
	private String userName;
	private String email;
	private int age;
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String name, String email, int age, String password) {
		super();
		this.userName = name;
		this.email = email;
		this.age = age;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return userName;
	}
	public void setName(String name) {
		this.userName = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", age=" + age + ", password=" + password
				+ "]";
	}
}
