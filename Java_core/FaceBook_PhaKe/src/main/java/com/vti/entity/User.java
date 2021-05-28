package com.vti.entity;

public class User {
	private int id;
	private String userName;
	private String email;
	private int age;
	private String password;
	public User(int i, String string) {
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

	public User(String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, String email, int age) {
		this.id =id;
		this.userName = userName;
		this.email = email;
		this.age = age;
	}
	public User(int int1, String string, String string2) {
		this.id = int1;
		this.userName =string;
		this.email =string2;
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
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", age=" + age ;
	}
	public String toStringIdandName() {
		return "ID : " + id +" || "+"UserName :" + userName ;
	}

}
