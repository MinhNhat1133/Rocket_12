package com.vti.entity;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;


public class Account {
	private int accountID;
	private String email;
	private String userName;
	private String firstName;
	private String lastName;
	private String fullName;
	private Department 	department;
	private Position	position;
	private Group[] groups;
	private LocalDate createDate;
	
	
	//Tao constructor
	public Account (){
		
	}
	
	public Account(int id,String email,String userName,String firstName,String lastName){
		this.setAccountID(id);
		this.email = email;
		this.setUserName(userName);
		this.firstName = firstName;
		this.lastName = lastName;
		this.setFullName(firstName +" "+ lastName);
	}
	
	public Account(int id,String email,String userName,String firstName,String lastName,Position position){
		this.setAccountID(id);
		this.email = email;
		this.setUserName(userName);
		this.firstName = firstName;
		this.lastName = lastName;
		this.setFullName(firstName +" "+ lastName);
		this.position = position;
		this.createDate = LocalDate.now();
	}
	public Account(int id,String email,String userName,String firstName,String lastName,Position position,LocalDate CreateDate){
		this.setAccountID(id);
		this.email = email;
		this.setUserName(userName);
		this.firstName = firstName;
		this.lastName = lastName;
		this.setFullName(firstName +" "+ lastName);
		this.position = position;
		this.createDate = CreateDate;
	}
	public Account(String userName) {
		this.setUserName(userName);
	}
	@Override
	public String toString() {
		return "Account{" + "id=" + getAccountID() + ", email='" + email + '\'' + ", username='" + getUserName() + '\'' + ", fullname='"
				+ getFullName() + '\'' + ", department=" + department + ", position=" + position + ", createDate="
				+ createDate + ", groups=" + Arrays.toString(groups) + '}';
	}


	public void setId(int id) {
		this.setAccountID(id);
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return getUserName();
	}

	public void setUsername(String username) {
		this.setUserName(username);
	}

	public String getFullname() {
		return getFullName();
	}

	public void setFullname(String fullname) {
		this.setFullName(fullname);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}

	

